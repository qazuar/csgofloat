package utils.patterns.weapons;

import utils.PatternUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KarambitMarbleFadePU implements PatternUtil {

    private Map<String, List<Integer>> indexes = new HashMap<>();

    public KarambitMarbleFadePU() {
        init();
    }

    private void init() {
        indexes.put("1st", Arrays.asList(412));
        indexes.put("2nd", Arrays.asList(359, 393, 602, 649, 701, 16, 146, 241, 541, 688));
        indexes.put("3rd", Arrays.asList(281, 673, 743, 292, 344, 994, 152, 777, 628, 792));
        indexes.put("4th", Arrays.asList(332, 129, 918, 126, 787, 874, 908, 923, 48, 780));
        indexes.put("5th", Arrays.asList(204, 252, 652, 736, 832, 705, 182, 457, 660, 685, 522, 578, 988));
        indexes.put("6th", Arrays.asList(230, 982, 607, 773, 444, 452, 471, 631, 356, 340, 621, 761, 112, 876, 873));
        indexes.put("7th", Arrays.asList(14, 274, 614, 653, 795, 826, 405, 454, 683, 728, 8, 32, 58, 108, 233, 732, 770, 803, 867, 949, 213, 243, 702));
        indexes.put("8th", Arrays.asList(337, 378, 188, 202, 971, 5, 178, 406, 539, 696, 854, 966, 655, 461));
        indexes.put("9th", Arrays.asList(493, 922, 959, 997, 68, 149, 171, 637, 287, 165, 206, 370, 656, 766, 817, 499, 516, 672, 706, 121));
        indexes.put("10th", Arrays.asList(238, 545, 591, 177, 546, 589, 977, 764, 844, 156, 868, 402, 28, 791, 553, 559, 725, 810, 858, 972));
        indexes.put("max", Arrays.asList(372, 441, 632, 329, 232, 756, 727, 753, 976, 351, 809, 941, 90, 785, 805, 195, 561, 590, 27, 459, 710, 930, 397, 404, 473, 483, 537, 626, 818, 962, 254, 909,
                125, 869, 647, 203, 183, 9, 110, 980, 448, 989));
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
