package utils;

import utils.patterns.KarambitMarbleFadePU;

public class PatternUtilFinder {

    public static PatternUtil find(String weaponType, int index) {
        String key = weaponType.toLowerCase() + "_" + index;
        switch (key) {
            case "karambit_413": return new KarambitMarbleFadePU();
        }

        return null;
    }

}
