package enums;

public enum MarketEnum {

    TALON_KNIFE_FADE("market/listings/730/%E2%98%85%20Talon%20Knife%20%7C%20Fade%20%28{}%29"),
    TALON_KNIFE_DOPPLER("market/listings/730/%E2%98%85%20Talon%20Knife%20%7C%20Doppler%20%28{}%29"),
    AWP_ASIIMOV_STATTRAK("market/listings/730/StatTrak%E2%84%A2%20AWP%20%7C%20Asiimov%20%28{}%29"),
    AWP_DRAGON_LORE("market/listings/730/AWP%20|%20Dragon%20Lore%20%28{}%29"),
    AWP_PRINCE("market/listings/730/AWP%20%7C%20The%20Prince%20%28{}%29"),
    SPECIALIST_GLOVES_FADE("market/listings/730/%E2%98%85%20Specialist%20Gloves%20%7C%20Fade%20%28{}%29"),
    SPECIALIST_GLOVES_CRIMSON_KIMONO("market/listings/730/%E2%98%85%20Specialist%20Gloves%20%7C%20Crimson%20Kimono%20%28{}%29");

    private String marketLink;

    MarketEnum(String marketLink) {
        this.marketLink = marketLink;
    }

    public String getMarketLink() {
        return this.marketLink;
    }

    public String getMarketLink(String exterior) {
        return this.marketLink.replace("{}", exterior);
    }

}
