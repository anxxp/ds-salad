package Array;

import static Array.ArrayUtility.swap;

public class QuickSortArray {


    public static void main(String args[]){
        //int[] input = {2,10,5,2,8,12,4,6,}; //Failing case
        //int[] input = {1,2,8,12,14,15};
        //int[] input = {2,2,2,2,2};
        int[] input = {14,12,8,2,1};
        quickSort(input);
        for (int i=0;i<input.length;i++){
            System.out.println(input[i]);
        }
    }

    private static void quickSort(int[] input) {

        quickSort(input,0,input.length-1);
    }

    private static void quickSort(int[] input, int start, int end) {

        if(end > start){
            int partitionIndex = getPartitionIndex(input,start,end);
            quickSort(input,start,partitionIndex-1);
            quickSort(input,partitionIndex+1,end);
        }
    }

    private static int getPartitionIndex(int[] input, int start, int end) {

        int pivotIndex = start;
        int pivot = input[pivotIndex];

        int left = start;
        int right = end;

        while(left<right){

            while(left<=end && input[left] <= pivot){
                left++;
            }
            while(input[right]>pivot){
                right--;
            }

            if(left < right){
                swap(input,left,right);
                left++;
                right--;
            }
        }
        swap(input,pivotIndex,right);
        return right;
    }


}
