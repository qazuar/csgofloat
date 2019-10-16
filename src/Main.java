public class Main {

    public static void main(String[] args) {
        ItemObj item = DataMapper.getItem("steam://rungame/730/76561202255233023/+csgo_econ_action_preview%20M2646353517640087992A16878067099D14739836218185522367");
        //ItemObj item = DataMapper.getItem("steam://rungame/730/76561202255233023/+csgo_econ_action_preview%20S76561198018551044A16150356934D6957723464052024574");

        System.out.println(item.getFullItemName());
        System.out.println(String.format("%s -> Range: %s, %s", item.getFloatValue(), item.getMinFloat(), item.getMaxFloat()));
    }
}
