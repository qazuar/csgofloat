package test;

import enums.ExteriorEnum;
import enums.MarketEnum;
import model.*;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<MarketItemObj> marketItems = DataMapper.getMarketItems(MarketEnum.AWP_PRINCE.getMarketLink(ExteriorEnum.FACTORY_NEW.getUrl()));

        //marketItems.clear();

        for (MarketItemObj mItem : marketItems) {
            ItemObj item = DataMapper.getItem(mItem.getInspectLink());
            System.out.println(item.getFullItemName());
            System.out.println(item.getFloatValue());
            System.out.println(item.getPaintSeed());
            System.out.println(mItem.getPrice());
            System.out.println(System.lineSeparator());
        }
    }

}
