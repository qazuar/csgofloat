package main.java.test;

import main.java.enums.ExteriorEnum;
import main.java.enums.MarketEnum;
import main.java.model.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Receiver r = new Receiver();
        MarketChecker checker = new MarketChecker(r);
        Thread thread = new Thread(checker);

        thread.start();
    }
}

class MarketChecker implements Runnable {

    final int SLEEP_TIME = 30000;
    Receiver receiver;

    MarketChecker(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void run() {
        System.out.println("Starting job");
        Map<String, ItemObj> savedItems = new HashMap<>();
        List<MarketItemObj> mItems;
        LocalDateTime timestamp;

        int previousCount = 0;
        double fv = 0.4;
        String target = MarketEnum.M4A4_THE_EMPEROR.getMarketLink(ExteriorEnum.MINIMAL_WEAR.getUrl(), true);

        try {
            while (true) {
                System.out.println(String.format("Currently stored %s items", savedItems.size()));
                int counterId = 1;
                timestamp = LocalDateTime.now();

                mItems = receiver.getMarketItems(target, 20);

                if (previousCount > 0) {
                    if (mItems.size() != previousCount) {
                        System.out.println(String.format("%s: Count has changed from %s to %s", timestamp.toString(), previousCount, mItems.size()));
                    }
                } else {
                    System.out.println(String.format("%s: Found %s items", timestamp.toString(), mItems.size()));
                }

                previousCount = mItems.size();

                for (MarketItemObj mItem : mItems) {
                    ItemObj item = receiver.getItem(mItem.getInspectLink());
                    double cfv = Double.parseDouble(item.getFloatValue());

                    if (cfv < fv && savedItems.get(mItem.getInspectLink()) == null) {
                        savedItems.put(mItem.getInspectLink(), item);
                        System.out.println(String.format("%s: Item #%s has < %s float (%s) [%s]", timestamp.toString(), counterId, fv, cfv, mItem.getPrice()));
                    }

                    counterId ++;
                }

                Thread.sleep(SLEEP_TIME);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
