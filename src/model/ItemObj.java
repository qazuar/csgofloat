package model;

import utils.PatternUtil;
import utils.PatternUtilFinder;

public class ItemObj {

    // FROM CSGOFLOAT DOC
    /**
     itemid 	uint32 	Item ID
     defindex 	uint32 	Weapon ID
     paintindex 	uint32 	Paint ID of the weapon (skin)
     rarity 	uint32 	Rarity value of the weapon
     quality 	uint32 	Quality of the weapon
     paintwear 	uint32 	Wear of the exterior of the skin
     paintseed 	uint32 	Seed for the RNG that defines how to place the skin texture
     killeatervalue 	uint32 	If the item is StatTrak, this is the amount of kills
     customname 	string 	If the item has a nametag, this is the custom name
     stickers 	array 	Contains data on the placement of stickers
     origin 	uint32 	Origin ID of the weapon
     floatvalue 	float 	Exterior wear of the skin in its float representation
     imageurl 	string 	Optional: Image of the item
     min 	float 	Minimum wear of the skin
     max 	float 	Maximum wear of the skin
     itemid_int 	uint32 	ID of the item
     item_name 	uint32 	Optional: Name of the skin
     weapon_type 	string 	Weapon type name
     */

    private String itemId;
    private String definitionIndex;
    private int paintIndex;
    private String rarity;
    private String rarityName;
    private String quality;
    private String qualityName;
    private String paintWear;
    private int paintSeed; // Seed for the RNG that defines how to place the skin texture
    private String killEaterValue; // If the item is StatTrak, this is the amount of kills
    private String customName; // If the item has a nametag, this is the custom name
    private String[] stickers; // Contains data on the placement of stickers
    private String origin; // Origin ID of the weapon
    private String originName; // Where was it obtained
    private String floatValue;
    private String imageUrl;
    private String minFloat;
    private String maxFloat;
    private String itemidInt; // Same as itemId?
    private String itemName;
    private String fullItemName;
    private String weaponType;
    private String wearName;

    private String fullItemNameClean;
    private String exterior;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDefinitionIndex() {
        return definitionIndex;
    }

    public void setDefinitionIndex(String definitionIndex) {
        this.definitionIndex = definitionIndex;
    }

    public int getPaintIndex() {
        return paintIndex;
    }

    public void setPaintIndex(String paintIndex) {
        this.paintIndex = Integer.parseInt(paintIndex.split("\\.")[0]);
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getRarityName() {
        return rarityName;
    }

    public void setRarityName(String rarityName) {
        this.rarityName = rarityName;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getQualityName() {
        return qualityName;
    }

    public void setQualityName(String qualityName) {
        this.qualityName = qualityName;
    }

    public String getPaintWear() {
        return paintWear;
    }

    public void setPaintWear(String paintWear) {
        this.paintWear = paintWear;
    }

    public int getPaintSeed() {
        return paintSeed;
    }

    public void setPaintSeed(String paintSeed) {
        this.paintSeed = Integer.parseInt(paintSeed.split("\\.")[0]);
    }

    public String getPatternName() {
        PatternUtil util = PatternUtilFinder.find(weaponType, paintIndex);

        if (util == null) {
            return null;
        }

        return util.validate(paintSeed);
    }

    public String getKillEaterValue() {
        return killEaterValue;
    }

    public void setKillEaterValue(String killEaterValue) {
        this.killEaterValue = killEaterValue;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String[] getStickers() {
        return stickers;
    }

    public void setStickers(String[] stickers) {
        this.stickers = stickers;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(String floatValue) {
        this.floatValue = floatValue;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMinFloat() {
        return minFloat;
    }

    public void setMinFloat(String minFloat) {
        this.minFloat = minFloat;
    }

    public String getMaxFloat() {
        return maxFloat;
    }

    public void setMaxFloat(String maxFloat) {
        this.maxFloat = maxFloat;
    }

    public String getItemidInt() {
        return itemidInt;
    }

    public void setItemidInt(String itemidInt) {
        this.itemidInt = itemidInt;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getFullItemName() {
        return fullItemName;
    }

    public void setFullItemName(String fullItemName) {
        this.fullItemName = fullItemName;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public String getWearName() {
        return wearName;
    }

    public void setWearName(String wearName) {
        this.wearName = wearName;
    }

    public String getFullItemNameClean() {
        return fullItemNameClean;
    }

    public void setFullItemNameClean(String fullItemNameClean) {
        this.fullItemNameClean = fullItemNameClean;
    }

    public String getExterior() {
        return exterior;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
    }
}
