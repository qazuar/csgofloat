import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

public class CsgoMapper {

    final static String API_ADDRESS = "https://api.csgofloat.com/";

    public static LinkedTreeMap<String, String> getLinkedTreeMapFromLink(String inspectLink) {
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

        return map;
    }
}
