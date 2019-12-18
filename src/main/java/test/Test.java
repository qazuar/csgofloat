package main.java.test;

import main.java.enums.ExteriorEnum;
import main.java.enums.MarketEnum;
import main.java.model.*;

import java.time.LocalDateTime;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Receiver r = new Receiver();
        MarketChecker checker = new MarketChecker(r);
        Thread thread = new Thread(checker);

        thread.start();
    }
}

class MarketChecker implements Runnable {

    final int SLEEP_TIME = 20000;
    Receiver receiver;

    MarketChecker(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void run() {
        System.out.println("Starting job");
        List<MarketItemObj> mItems;
        LocalDateTime timestamp;

        int previousFTCount = 0;
        int previousMWCount = 0;

        try {
            while (true) {
                //System.out.println("Checking FT");
                timestamp = LocalDateTime.now();

                mItems = receiver.getMarketItems(MarketEnum.AK47_WILD_LOTUS.getMarketLink(ExteriorEnum.FIELD_TESTED.getUrl()), 10);

                if (previousFTCount > 0) {
                    if (mItems.size() != previousFTCount) {
                        System.out.println(String.format("%s: AK FT count has changed from %s to %s", timestamp.toString(), previousFTCount, mItems.size()));
                    }
                } else {
                    System.out.println(String.format("%s: Found %s AK FT", timestamp.toString(), mItems.size()));
                }

                previousFTCount = mItems.size();

                for (MarketItemObj mItem : mItems) {
                    ItemObj item = receiver.getItem(mItem.getInspectLink());
                    double fv = Double.parseDouble(item.getFloatValue());

                    if (fv < 0.2) {
                        System.out.println(timestamp.toString() + ": Found AK47 with < 0.2 float" + " (" + fv + ")");
                    }
                }

                //System.out.println("Checking MW");
                mItems = receiver.getMarketItems(MarketEnum.AK47_WILD_LOTUS.getMarketLink(ExteriorEnum.MINIMAL_WEAR.getUrl()), 10);

                if (previousMWCount > 0) {
                    if (mItems.size() != previousMWCount) {
                        System.out.println(String.format("%s: AK MW count has changed from %s to %s", timestamp.toString(), previousMWCount, mItems.size()));
                    }
                } else {
                    System.out.println(String.format("%s: Found %s AK MW", timestamp.toString(), mItems.size()));
                }

                previousMWCount = mItems.size();

                for (MarketItemObj mItem : mItems) {
                    ItemObj item = receiver.getItem(mItem.getInspectLink());
                    double fv = Double.parseDouble(item.getFloatValue());

                    if (fv < 0.09) {
                        System.out.println(timestamp.toString() + ": Found AK47 with < 0.12 float" + " (" + fv + ")");
                    }
                }

                Thread.sleep(SLEEP_TIME);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
