package model;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

public class DataMapper {

    final static String API_ADDRESS = "https://api.csgofloat.com/";

    public static ItemObj getItem(String inspectLink) {
        Connector connector = new Connector(null);
        Request request = Request.newRequest();

        request.setServer(API_ADDRESS);
        connector.get(request, "?url=" + inspectLink);

        Gson gson = new Gson();

        LinkedTreeMap<String, LinkedTreeMap<String, String>> head = gson.fromJson(request.getResponseXml(), LinkedTreeMap.class);
        LinkedTreeMap<String, String> map = null;

        for (String iteminfo : head.keySet()) {
            map = head.get(iteminfo);
        }

        return map2ItemObj(map);
    }

    private static ItemObj map2ItemObj(LinkedTreeMap<String, String> map) {
        if (map == null) {
            return null;
        }

        ItemObj item = new ItemObj();

        //for (String key : map.keySet()) {
        //    System.out.println(String.format("Key: %s -> Value: %s", key, map.get(key)));
        //}

        item.setOrigin(String.format("%s", map.get("origin")));
        item.setQuality(String.format("%s", map.get("quality")));
        item.setRarity(String.format("%s", map.get("rarity")));
        item.setPaintSeed(String.format("%s", map.get("paintseed")));
        item.setDefinitionIndex(String.format("%s", map.get("defindex")));
        item.setPaintIndex(String.format("%s", map.get("paintindex")));
        item.setStickers(null); // Not sure about the actual value
        item.setFloatValue(String.format("%s", map.get("floatvalue")));
        item.setImageUrl(map.get("imageurl"));
        item.setMinFloat(String.format("%s", map.get("min")));
        item.setMaxFloat(String.format("%s", map.get("max")));
        item.setWeaponType(map.get("weapon_type"));
        item.setItemName(map.get("item_name"));
        item.setRarityName(map.get("rarity_name"));
        item.setQualityName(map.get("quality_name"));
        item.setOriginName(map.get("origin_name"));
        item.setWearName(map.get("wear_name"));
        item.setFullItemName(map.get("full_item_name"));

        item.setFullItemNameClean(item.getFullItemName().split("\\(")[0]);
        item.setExterior(item.getFullItemName().split("\\(")[1].replace(")", ""));

        return item;
    }
}
