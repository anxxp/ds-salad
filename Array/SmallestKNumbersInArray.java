package Array;

import java.util.Random;

import static Array.ArrayUtility.swap;

public class SmallestKNumbersInArray {

    public static void main(String args[]){
        int[] input = {6,1,3,9,8,2,4,5};
        int k = 4;
        int[] output = smallestK(input,k);
        for (int i:
             output) {
            System.out.println(i);
        }
    }

    public static int[] smallestK(int[] array,int k){

        if(k<=0 || k > array.length){
            throw new IllegalArgumentException();
        }

        int threshold = rank(array,k);
        int[] smallest = new int[k];
        int count=0;
        for(int a: array){

            if(a <= threshold){
                smallest[count] = a;
                count++;
            }
        }
        return smallest;
    }

    private static int rank(int[] array,int rank){
        return rank(array,0,array.length-1,rank);
    }

    private static int rank(int[] array, int left, int right, int rank) {
        int pivot = array[randomIntInRange(left,right)];
        int leftEnd = partition(array,left,right,pivot);

        int leftSize = leftEnd-left+1;
        if(rank== leftSize){
            return max(array,left,leftEnd);
        }else if(rank < leftSize){
            return rank(array,left,leftEnd,rank);
        }else{
            return rank(array,leftEnd+1,right,rank-leftSize);
        }
    }

    private static int partition(int[] array, int left, int right, int pivot) {

        while (left<=right){
            if (array[left] > pivot){
                swap(array,left,right);
                right--;
            }else if(array[right] <= pivot){
                swap(array,left,right);
                left++;
            }else{
                left++;
                right--;
            }
        }
        return left-1;
    }

    private static int randomIntInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max+1-min)+min;
    }

    private static int max(int[] array, int start, int end){
        int max = Integer.MIN_VALUE;
        for (int i=start;i<=end;i++){
            max = Math.max(max,array[i]);
        }
        return max;
    }
}
