package utils;

import utils.patterns.KarambitMarbleFadePU;

public class PatternUtilFinder {

    public static PatternUtil find(int index) {
        switch (index) {
            case 413: return new KarambitMarbleFadePU();
        }

        return null;
    }

}
