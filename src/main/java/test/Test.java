package main.java.test;

import main.java.enums.ExteriorEnum;
import main.java.enums.MarketEnum;
import main.java.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    private final int SLEEP_TIME = 30000;
    private Receiver receiver;

    MarketChecker(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void run() {
        System.out.println("Starting job");
        Map<String, ItemObj> savedItems = new HashMap<>();
        MarketObj marketObj;
        LocalDateTime timestamp;

        boolean repeat = false;
        int fetchCount = 50;
        String target = MarketEnum.AK47_REDLINE.getMarketLink(ExteriorEnum.FIELD_TESTED.getUrl(), false);

        try {
            while (true) {
                int counterId = 1;
                timestamp = LocalDateTime.now();

                marketObj = receiver.getMarketObject(target, fetchCount);

                if (savedItems.isEmpty()) {
                    System.out.println(String.format("%s: Found %s items", timestamp.toString(), marketObj.getItems().size()));
                }

                for (MarketItemObj mItem : marketObj.getItems()) {
                    ItemObj item = receiver.getItem(mItem.getInspectLink());

                    if (savedItems.get(mItem.getInspectLink()) == null) {
                        savedItems.put(mItem.getInspectLink(), item);
                        System.out.println(String.format("%s: Item #%s ~> float=%s, paintindex=%s, seed=%s [%s]", timestamp.toString(), counterId, item.getFloatValue(), item.getPaintIndex(), item.getPaintSeed(), mItem.getPrice()));
                    }

                    counterId ++;
                }

                for (ItemObj item : getMissingItems(savedItems, marketObj.getItems())) {
                    System.out.println(String.format("%s: Item is missing ~> float=%s, paintindex=%s, seed=%s", timestamp.toString(), item.getFloatValue(), item.getPaintIndex(), item.getPaintSeed()));
                }

                if (!repeat) {
                    break;
                }

                Thread.sleep(SLEEP_TIME);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<ItemObj> getMissingItems(Map<String, ItemObj> savedItems, List<MarketItemObj> mItems) {
        List<ItemObj> items = new ArrayList<>();
        List<String> delete = new ArrayList<>();

        for (String key : savedItems.keySet()) {
            boolean found = false;

            for (MarketItemObj mItem : mItems) {
                if (mItem.getInspectLink().equalsIgnoreCase(key)) {
                    found = true;
                }
            }

            if (!found) {
                items.add(savedItems.get(key));
                delete.add(key);
            }
        }

        for (String key : delete) {
            savedItems.remove(key);
        }

        return items;
    }
}
