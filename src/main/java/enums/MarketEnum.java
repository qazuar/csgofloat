package main.java.enums;

public enum MarketEnum {

    BAYONET_SLAUGHTER("market/listings/730/%E2%98%85%20Bayonet%20%7C%20Slaughter%20%28{}%29", true),
    M9_KNIFE_LORE("market/listings/730/%E2%98%85%20M9%20Bayonet%20%7C%20Lore%20%28{}%29", true),
    TALON_KNIFE_FADE("market/listings/730/%E2%98%85%20Talon%20Knife%20%7C%20Fade%20%28{}%29", true),
    TALON_KNIFE_DOPPLER("market/listings/730/%E2%98%85%20Talon%20Knife%20%7C%20Doppler%20%28{}%29", true),
    AK47_FIRE_SERPENT("market/listings/730/AK-47%20%7C%20Fire%20Serpent%20%28{}%29", true),
    AK47_REDLINE("market/listings/730/AK-47%20%7C%20Redline%20%28{}%29", true),
    AK47_WILD_LOTUS("market/listings/730/AK-47%20%7C%20Wild%20Lotus%20%28{}%29", false),
    AWP_ASIIMOV("market/listings/730/AWP%20%7C%20Asiimov%20%28{}%29", true),
    AWP_DRAGON_LORE("market/listings/730/AWP%20|%20Dragon%20Lore%20%28{}%29", false),
    AWP_GUNGNIR("market/listings/730/AWP%20%7C%20Gungnir%20%28{}%29", false),
    AWP_MEDUSA("market/listings/730/AWP%20%7C%20Medusa%20%28{}%29", false),
    AWP_THE_PRINCE("market/listings/730/AWP%20%7C%20The%20Prince%20%28{}%29", false),
    AWP_WILDFIRE("market/listings/730/AWP%20%7C%20Wildfire%20%28{}%29", true),
    DEAGLE_BLAZE("market/listings/730/Desert%20Eagle%20%7C%20Blaze%20%28{}%29", false),
    DEAGLE_CODE_RED("market/listings/730/Desert%20Eagle%20%7C%20Code%20Red%20%28{}%29", true),
    KARAMBIT_DOPPLER("market/listings/730/%E2%98%85%20Karambit%20%7C%20Doppler%20%28{}%29", true),
    KARAMBIT_MARBLE_FADE("market/listings/730/%E2%98%85%20Karambit%20%7C%20Marble%20Fade%20%28{}%29", true),
    M4A1_KNIGHT("market/listings/730/M4A1-S%20%7C%20Knight%20%28{}%29", false),
    M4A4_ASIIMOV("market/listings/730/M4A4%20%7C%20Asiimov%20%28{}%29", true),
    M4A4_NEO_NOIR("market/listings/730/M4A4%20%7C%20Neo-Noir%20%28{}%29", true),
    M4A4_THE_EMPEROR("market/listings/730/M4A4%20%7C%20The%20Emperor%20%28{}%29", true),
    MAG7_CINQUEDEA("market/listings/730/MAG-7%20%7C%20Cinquedea%20%28{}%29", false),
    MP9_LILY("market/listings/730/MP9%20%7C%20Wild%20Lily%20%28{}%29", false),
    NEGEV_MJÖLNIR("market/listings/730/Negev%20%7C%20Mjölnir%20%28{}%29", false),
    P250_ASIIMOV("market/listings/730/P250%20%7C%20Asiimov%20%28{}%29", true),
    SG553_INTEGRALE("market/listings/730/SG%20553%20%7C%20Integrale%20%28{}%29", false),
    SPECIALIST_GLOVES_FADE("market/listings/730/%E2%98%85%20Specialist%20Gloves%20%7C%20Fade%20%28{}%29", false),
    SPECIALIST_GLOVES_CRIMSON_KIMONO("market/listings/730/%E2%98%85%20Specialist%20Gloves%20%7C%20Crimson%20Kimono%20%28{}%29", false),
    SPORT_GLOVES_PANDORA("market/listings/730/%E2%98%85%20Sport%20Gloves%20%7C%20Pandora%27s%20Box%20%28{}%29", false),
    SPORT_GLOVES_OMEGA("market/listings/730/%E2%98%85%20Sport%20Gloves%20%7C%20Omega%20%28{}%29", false),
    SPORT_GLOVES_SUPERCONDUCTOR("market/listings/730/%E2%98%85%20Sport%20Gloves%20%7C%20Superconductor%20%28{}%29", false),
    SPORT_GLOVES_VICE("market/listings/730/%E2%98%85%20Sport%20Gloves%20%7C%20Vice%20%28{}%29", false),
    USP_ORION("market/listings/730/USP-S%20%7C%20Orion%20%28{}%29", true);

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
