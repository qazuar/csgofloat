package enums;

public enum ApiEnum {

    STEAM_COMMUNITY_ADDRESS("https://steamcommunity.com/"),
    CSGOFLOAT_API("https://api.csgofloat.com/"),
    STEAM_RUN_CSGO_PREFIX("steam://rungame/730/76561202255233023/+csgo_econ_action_preview");

    private String path;

    ApiEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
