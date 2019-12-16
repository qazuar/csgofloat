package utils.patterns.weapons;

import utils.PatternUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KarambitFadePU implements PatternUtil {

    private Map<String, List<Integer>> indexes = new HashMap<>();

    public KarambitFadePU() {
        init();
    }

    private void init() {
        indexes.put("90/10", Arrays.asList(412));
        indexes.put("90/3/7", Arrays.asList(359, 393, 602, 649, 701, 16, 146, 241, 541, 688));
        indexes.put("90/5/5", Arrays.asList(281, 673, 743, 292, 344, 994, 152, 777, 628, 792));
        indexes.put("4th", Arrays.asList(332, 129, 918, 126, 787, 874, 908, 923, 48, 780));
    }

    @Override
    public String validate(int seed) {
        for (String key : indexes.keySet()) {
            for (Integer i : indexes.get(key)) {
                if (seed == i) {
                    return key;
                }
            }
        }

        return null;
    }

}
