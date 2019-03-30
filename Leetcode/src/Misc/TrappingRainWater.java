package Misc;

/**
 * Given n non-negative integers representing an
 * elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after
 * raining.
 * <p>
 * 14   ^
 * 13	|
 * 12	|	 11
 * 11	|	HHH
 * 10	|	HHH          9
 * 9	|	HHH----8----HHH
 * 8	|	HHH---HHH---HHH       7
 * 7	|	HHH---HHH---HHH------HHH
 * 6	|	HHH---HHH---HHH-5----HHH
 * 5	|	HHH-6-HHH---HHHHHH---HHH
 * 4	|	HHHHHHHHH---HHHHHH-3-HHH
 * 3	|	HHHHHHHHH 2 HHHHHHHHHHHH 2
 * 2	|	HHHHHHHHHHHHHHHHHHHHHHHHHHH 1
 * 1	|	HHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
 * 0    |---------------------------------------->
 * <p>
 * The above elevation map is represented by
 * array [0,11,6,8,2,9,5,3,7,2,1,0].
 * <p>
 * Trapped Rain Water is represented by hyphen above.
 */

public class TrappingRainWater {

    public static void main(String args[]) {
        int[] histogram = {0, 11, 6, 8, 2, 9, 5, 3, 7, 2, 1, 0};

        System.out.println(calculateVolumeOfTrappedWater(histogram));
    }

    private static int calculateVolumeOfTrappedWater(int[] histogram) {

        int trappedWater = 0;
        int[] maxBarHeightOnLeft = new int[histogram.length];

        int maxHeight = histogram[0];
        for (int i = 0; i < histogram.length; i++) {
            maxHeight = Math.max(maxHeight, histogram[i]);
            maxBarHeightOnLeft[i] = maxHeight;
        }

        maxHeight = histogram[histogram.length - 1];
        for (int i = histogram.length - 1; i >= 0; i--) {
            maxHeight = Math.max(maxHeight, histogram[i]);

            trappedWater += Math.min(maxBarHeightOnLeft[i], maxHeight) - histogram[i];
        }
        return trappedWater;
    }


}
