package SlidingWindow;

import java.util.LinkedList;

/**
 * Question : 239
 * <p>
 * Given an array nums, there is a sliding window
 * of size k which is moving from the very left of
 * the array to the very right. You can only see the
 * k numbers in the window. Each time the sliding window
 * moves right by one position. Return the max sliding window.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1  [3  -1  -3] 5  3  6  7       3
 * 1   3 [-1  -3  5] 3  6  7       5
 * 1   3  -1 [-3  5  3] 6  7       5
 * 1   3  -1  -3 [5  3  6] 7       6
 * 1   3  -1  -3  5 [3  6  7]      7
 **/

public class SlidingWindowMaximum {

    public static void main(String args[]) {
        int[] inputArray = {1, 3, -1, -3, 5, 3, 6, 7};
        int windowSize = 3;
        //int[] inputArray = {1,-1};
        //int windowSize = 1;
        //int[] inputArray = {7,2,4};
        //int windowSize = 2;

        if (inputArray.length == 0) {
            return;
        }
        LinkedList<Integer> potentialMaxIndices = new LinkedList<>();
        for (int i = 0; i < windowSize; i++) {
            while (!potentialMaxIndices.isEmpty() &&
                    inputArray[i] > inputArray[potentialMaxIndices.getLast()]) {
                potentialMaxIndices.removeLast();
            }
            potentialMaxIndices.add(i);
        }
        System.out.println(inputArray[potentialMaxIndices.getFirst()]);

        int len = inputArray.length;
        for (int i = windowSize; i < len; i++) {

            /**
             * remove elements (indexes) that are not part of the current window
             */

            while (!potentialMaxIndices.isEmpty() &&
                    potentialMaxIndices.getFirst() <= i - windowSize) {
                potentialMaxIndices.removeFirst();
            }
            /***
             *
             * remove all the elements (indexes) which are not potential max for current or future windows
             */
            while (!potentialMaxIndices.isEmpty() &&
                    inputArray[potentialMaxIndices.getLast()] < inputArray[i]) {
                potentialMaxIndices.removeLast();
            }
            /***
             *
             * add the current element(index) if its potential max for current or future windows.
             * NOTE : the add the current element even if its equal to the last element
             * because it could be a potential max for window starting at that index.
             */
            /*if (potentialMaxIndices.isEmpty() ||
                    inputArray[potentialMaxIndices.getLast()] >= inputArray[i]) {
                potentialMaxIndices.add(i);
            }*/
            potentialMaxIndices.add(i);
            /***
             * print the current window max
             */
            System.out.println(inputArray[potentialMaxIndices.getFirst()]);
        }
    }
}
