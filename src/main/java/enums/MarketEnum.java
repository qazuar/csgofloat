package main.java.enums;

public enum MarketEnum {

    TALON_KNIFE_FADE("market/listings/730/%E2%98%85%20Talon%20Knife%20%7C%20Fade%20%28{}%29", true),
    TALON_KNIFE_DOPPLER("market/listings/730/%E2%98%85%20Talon%20Knife%20%7C%20Doppler%20%28{}%29", true),
    AK47_WILD_LOTUS("market/listings/730/AK-47%20%7C%20Wild%20Lotus%20%28{}%29", false),
    AWP_ASIIMOV("market/listings/730/AWP%20%7C%20Asiimov%20%28{}%29", true),
    AWP_DRAGON_LORE("market/listings/730/AWP%20|%20Dragon%20Lore%20%28{}%29", false),
    AWP_GUNGNIR("market/listings/730/AWP%20%7C%20Gungnir%20%28{}%29", false),
    AWP_THE_PRINCE("market/listings/730/AWP%20%7C%20The%20Prince%20%28{}%29", false),
    AWP_WILDFIRE("market/listings/730/AWP%20%7C%20Wildfire%20%28{}%29", true),
    DEAGLE_BLAZE("market/listings/730/Desert%20Eagle%20%7C%20Blaze%20%28{}%29", false),
    DEAGLE_CODE_RED("market/listings/730/Desert%20Eagle%20%7C%20Code%20Red%20%28{}%29", true),
    M4A4_ASIIMOV("market/listings/730/M4A4%20%7C%20Asiimov%20%28{}%29", true),
    M4A4_NEO_NOIR("market/listings/730/M4A4%20%7C%20Neo-Noir%20%28{}%29", true),
    M4A4_THE_EMPEROR("market/listings/730/M4A4%20%7C%20The%20Emperor%20%28{}%29", true),
    P250_ASIIMOV("market/listings/730/P250%20%7C%20Asiimov%20%28{}%29", true),
    SPECIALIST_GLOVES_FADE("market/listings/730/%E2%98%85%20Specialist%20Gloves%20%7C%20Fade%20%28{}%29", false),
    SPECIALIST_GLOVES_CRIMSON_KIMONO("market/listings/730/%E2%98%85%20Specialist%20Gloves%20%7C%20Crimson%20Kimono%20%28{}%29", false),
    SPORT_GLOVES_PANODRA("market/listings/730/%E2%98%85%20Sport%20Gloves%20%7C%20Pandora%27s%20Box%20%28{}%29", false),
    SPORT_GLOVES_OMEGA("market/listings/730/%E2%98%85%20Sport%20Gloves%20%7C%20Omega%20%28{}%29", false);

    private final String statTrakPrefix = "StatTrak%E2%84%A2%20";
    private String marketLink;
    private Boolean hasStatTrak;

    MarketEnum(String marketLink, Boolean hasStatTrak) {
        this.marketLink = marketLink;
        this.hasStatTrak = hasStatTrak;
    }

    public String getMarketLink(String exterior, boolean statTrak) {
        return this.marketLink.replace("{}", exterior).replace("/730/", (statTrak && this.hasStatTrak) ? "/730/" + this.statTrakPrefix : "/730/");
    }

}
