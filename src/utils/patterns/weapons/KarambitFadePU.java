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
        indexes.put("90/10", Arrays.asList(146));
        indexes.put("90/3/7", Arrays.asList(1));
        indexes.put("90/5/5", Arrays.asList(1));
        indexes.put("90/7/3", Arrays.asList(1));
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
