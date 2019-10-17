package model;

public class MarketItemObj {

    private String inspectLink;
    private String price;

    public MarketItemObj(String inspectLink, String price) {
        this.inspectLink = inspectLink;
        this.price = price;
    }

    public String getInspectLink() {
        return inspectLink;
    }

    public String getPrice() {
        return price;
    }
}
