package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class MarketObj {

    private List<MarketItemObj> items = new ArrayList<>();
    private List<String> marketSale = new ArrayList<>(); //Change type to marketSaleObj something something

    public List<MarketItemObj> getItems() {
        return this.items;
    }

    public List<String> getMarketSale() {
        return this.marketSale;
    }
}
