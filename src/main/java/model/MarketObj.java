package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class MarketObj {

    private List<MarketItemObj> items = new ArrayList<>();
    private List<MarketSaleObj> marketSale = new ArrayList<>(); //Change type to marketSaleObj something something

    public List<MarketItemObj> getItems() {
        return this.items;
    }

    public List<MarketSaleObj> getMarketSale() {
        return this.marketSale;
    }

    public void addMarketSale(String[] saleHistory) {
        for (String x : saleHistory) {
            x = x.replace("\"", "").replace("[", "").replace("]", "").replace(";", "").toLowerCase();
            String[] c = x.split(",");

            String date = c[0];
            String price = c[1];
            String quantity = c[2];

            marketSale.add(new MarketSaleObj(date, Double.parseDouble(price), Integer.parseInt(quantity)));
        }
    }

    public Double getLowestSalesPrice() {
        double lowest = 999999;

        for (MarketSaleObj o : marketSale) {
            if (o.getPrice() < lowest) {
                lowest = o.getPrice();
            }
        }

        return lowest;
    }

    public Double getHighestSalesPrice() {
        double highest = 0;

        for (MarketSaleObj o : marketSale) {
            if (o.getPrice() > highest) {
                highest = o.getPrice();
            }
        }

        return highest;
    }

    public Double getAverageSalesPrice() {
        double total = 0;
        int count = 0;

        for (MarketSaleObj o : marketSale) {
            total += o.getPrice();
            count += o.getQuantity();
        }

        return total / count;
    }

    public int getTotalSales() {
        int count = 0;

        for (MarketSaleObj o : marketSale) {
            count += o.getQuantity();
        }

        return count;
    }
}
