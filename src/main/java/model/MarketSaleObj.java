package main.java.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MarketSaleObj {

    private final SimpleDateFormat df = new SimpleDateFormat("MMM dd yyyy HH", Locale.US);

    private Date salesDate;
    private Double price;
    private int quantity;

    public MarketSaleObj(String date, Double price, int quantity) {
        try {
            this.salesDate = df.parse(date);
        } catch (ParseException e) {
            this.salesDate = new Date();
            System.out.println(e.getMessage());
        }
        this.price = price;
        this.quantity = quantity;
    }

    public Date getSalesDate() {
        return this.salesDate;
    }

    public Double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
