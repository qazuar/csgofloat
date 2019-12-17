package model;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import enums.ApiEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Receiver {

    private Map<String, ItemObj> cache;

    public Receiver() {
        this.cache = new HashMap<>();
    }

    public ItemObj getItem(String inspectLink) {
        ItemObj item = cache.get(inspectLink);

        if (item == null) {
            System.out.println("! Received from cache");
        } else {
            System.out.println("Received from cache");
        }

        item = item == null ? fetch(inspectLink) : item;

        return item;
    }

    private ItemObj fetch(String inspectLink) {
        Connector connector = new Connector(null);
        Request request = Request.newRequest();

        request.setServer(ApiEnum.CSGOFLOAT_API.getPath());
        connector.get(request, "?url=" + inspectLink);

        Gson gson = new Gson();

        LinkedTreeMap<String, LinkedTreeMap<String, String>> head = gson.fromJson(request.getResponseXml(), LinkedTreeMap.class);
        LinkedTreeMap<String, String> map = null;

        for (String iteminfo : head.keySet()) {
            map = head.get(iteminfo);
        }

        ItemObj item = map2ItemObj(map);

        cache.put(inspectLink, item);

        return item;
    }

    private ItemObj map2ItemObj(LinkedTreeMap<String, String> map) {
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

        // A safety fix for really low float values
        item.setFloatValue(BigDecimal.valueOf(Double.valueOf(item.getFloatValue())).toString());

        return item;
    }

    public List<MarketItemObj> getMarketItems(String path, int count) {
        String queryStartCount = "?query=&start=0&count=" + count;

        List<MarketItemObj> items = new ArrayList<>();
        List<String> links = new ArrayList<>();
        List<String> assetIds = new ArrayList<>();
        List<String> prices = new ArrayList<>();

        Connector connector = new Connector(null);
        Request request = Request.newRequest();
        request.setServer(ApiEnum.STEAM_COMMUNITY_ADDRESS.getPath());

        connector.get(request, path + queryStartCount);

        String response = request.getResponseXml();

        String x, y, z;

        for (String s : response.split(" ")) {
            if (s.contains("+csgo") && !s.contains("%listing")) {
                x = s.split("\\+csgo_econ_action_preview")[1].split("\"")[0].trim();

                if (!links.contains(x)) {
                    links.add(x);
                }
            }

            if (s.contains("\"asset\":{\"currency\":0,\"appid\":730,\"contextid\":\"2\",\"id\":")) {
                y = s.split("\"asset\"")[1].split("\"id\":")[1].split(",")[0].replace("\"", "");

                if (!assetIds.contains(y)) {
                    assetIds.add(y);
                }
            }
        }

        for (String s : response.split("span")) {
            if (s.contains("market_listing_price_with_fee")) {
                z = s.split("market_listing_price_with_fee\">")[1].replace("</", "").trim();

                prices.add(z);
            }
        }

        int index = 0;

        for (String link : links) {
            MarketItemObj item = new MarketItemObj(ApiEnum.STEAM_RUN_CSGO_PREFIX.getPath() + link.replace("%assetid%", assetIds.get(index)), prices.get(index));
            items.add(item);
            index++;
        }

        return items;
    }
}
