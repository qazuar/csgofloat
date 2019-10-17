package enums;

public enum MarketEnum {

    TALON_KNIFE_FADE_FACTORY_NEW("market/listings/730/%E2%98%85%20Talon%20Knife%20%7C%20Fade%20%28Factory%20New%29"),
    TALON_KNIFE_DOPPLER_FACTORY_NEW("market/listings/730/%E2%98%85%20Talon%20Knife%20%7C%20Doppler%20%28Factory%20New%29"),
    DRAGON_LORE_FACTORY_NEW("market/listings/730/AWP%20|%20Dragon%20Lore%20(Factory%20New)");

    private String marketLink;

    MarketEnum(String marketLink) {
        this.marketLink = marketLink;
    }

    public String getMarketLink() {
        return this.marketLink;
    }

}
