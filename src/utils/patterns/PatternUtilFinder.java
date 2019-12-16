package utils.patterns;

import utils.PatternUtil;
import utils.patterns.weapons.*;

public class PatternUtilFinder {

    public static PatternUtil find(String weaponType, int index) {
        String key = weaponType.toLowerCase() + "_" + index;
        switch (key) {
            case "karambit_413": return new KarambitMarbleFadePU();
            case "karambit_?": return new KarambitFadePU();
        }

        return null;
    }

}
