package Array;

import java.sql.SQLOutput;

/** We would be using the Kadane's Algorithm for this.
 * This algorithm will work only when we have at-least one positive number
 * */

public class MaxSumContiguousSubArray {
  public static void main(String args[]) {
    int[] array = {1, -1, -3, 4};

      System.out.println("Maximum sum of a contigous subarray is : "+maxSumSubArray(array));
  }

  public static int maxSumSubArray(int[] array) {
    int maxSumEndingHere =0;
    int maxSumSoFar =0;
    for (int i = 0; i < array.length; i++) {
        maxSumEndingHere = maxSumEndingHere+array[i];
        if(maxSumEndingHere<0){
            maxSumEndingHere=0;
        }
        if(maxSumEndingHere>maxSumSoFar){
            maxSumSoFar=maxSumEndingHere;
        }
    }
    return maxSumSoFar;
  }
}
