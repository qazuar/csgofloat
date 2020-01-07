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

        boolean init = true;
        int fetchCount = 30;
        String target = MarketEnum.AK47_REDLINE.getMarketLink(ExteriorEnum.FIELD_TESTED.getUrl(), false);

        try {
            while (true) {
                int counterId = 1;
                timestamp = LocalDateTime.now();

                mItems = receiver.getMarketItems(target, fetchCount);

                if (init) {
                    System.out.println(String.format("%s: Found %s items", timestamp.toString(), mItems.size()));
                }

                for (MarketItemObj mItem : mItems) {
                    boolean isNew = savedItems.get(mItem.getInspectLink()) == null && init;

                    ItemObj item = receiver.getItem(mItem.getInspectLink());
                    double cfv = Double.parseDouble(item.getFloatValue());

                    if (savedItems.get(mItem.getInspectLink()) == null) {
                        savedItems.put(mItem.getInspectLink(), item);
                        System.out.println(String.format("%s: Item #%s ~> float (%s) [%s] %s", timestamp.toString(), counterId, cfv, mItem.getPrice(), isNew ? "[NEW]" : ""));
                    }

                    counterId ++;
                }

                init = false;

                Thread.sleep(SLEEP_TIME);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
