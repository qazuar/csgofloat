package main.java.utils.patterns;

import main.java.utils.PatternUtil;
import main.java.utils.patterns.weapons.*;

public class PatternUtilFinder {

    public static PatternUtil find(String weaponType, int index) {
        String key = weaponType.toLowerCase() + "_" + index;
        switch (key) {
            case "karambit_413": return new KarambitMarbleFadePU();
            case "karambit_38?": return new KarambitFadePU();
        }

        return null;
    }

}
