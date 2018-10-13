package DynamicProgramming;


/** We would be using the Kadane's Algorithm for this.
 * This algorithm will work only when we have at-least one positive number
 * */

public class MaxSumContiguousSubArray {
  public static void main(String args[]) {
    //int[] array = {1, -9, -3, 4};
    int[] array = {1, -3, 2,1,-1};

      System.out.println(" has maximum sum for a contiguous sub-array : "+maxSumSubArray(array));
  }

  public static int maxSumSubArray(int[] array) {
    int maxSumEndingHere =0;
    int maxSumSoFar =0;
    int start_index =0;
    int end_index =0;
    for (int i = 0; i < array.length; i++) {
        maxSumEndingHere = maxSumEndingHere+array[i];
        if(maxSumEndingHere<0){
            maxSumEndingHere=0;
            start_index=i+1;
        }
        if(maxSumEndingHere>maxSumSoFar){
            maxSumSoFar=maxSumEndingHere;
            end_index=i;
        }
    }
    System.out.print("The sub-array starting from "+start_index+" and ending at "+end_index);
    return maxSumSoFar;
  }
}
