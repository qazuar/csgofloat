import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

public class Main {

    public static void main(String[] args) {
        LinkedTreeMap<String, String> map = CsgoMapper.getLinkedTreeMapFromLink("steam://rungame/730/76561202255233023/+csgo_econ_action_preview%20S76561198018551044A16150356934D6957723464052024574");

        for (String key : map.keySet()) {
            System.out.println(String.format("Key: %s -> Value: %s", key, map.get(key)));
        }
    }
}
