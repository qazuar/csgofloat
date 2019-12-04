package enums;

public enum ExteriorEnum {

    BATTLE_SCARRED("Battle-Scarred", "Battle-Scarred"),
    WELL_WORN("Well-Worn", "Well-Worn"),
    FIELD_TESTED("Field-Tested", "Field-Tested"),
    MINIMAL_WEAR("Minimal Wear", "Minimal%20Wear"),
    FACTORY_NEW("Factory New", "Factory%20New");

    private String name;
    private String url;

    ExteriorEnum(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }
}
