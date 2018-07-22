package Matrix;

import Array.ArrayUtility;

public class MaxBinaryNumber {

    public static void main(String args[]){

        int[][] input = new int[][]{
                { 0, 0, 1, 1, 0, 0},
                { 0, 0, 1, 0, 0, 0},
                { 0, 0, 1, 0, 1, 0},
                { 0, 0, 1, 1, 1, 0},
                { 0, 0, 1, 0, 1, 0}
        };
        System.out.println(indexOfMaxBinaryNum(input));
    }

    private static int indexOfMaxBinaryNum(int[][] input) {
        int numberOfRows = input.length;
        int numberOfCols = input[0].length;
        /**
         * Array to keep track of indices
         * */
        int array[] = new int[numberOfRows];
        for (int i = 0; i < numberOfRows; i++) {
            array[i] = i;
        }

        int lastIndexOfOne = numberOfRows - 1;
        /**
         * Index of the last 1
         * */
        int firstValidColumn =0;
        for (int i = 0; i < numberOfCols; i++) {

            while (lastIndexOfOne>=0 && input[lastIndexOfOne][i] <= 0) {
                lastIndexOfOne--;
            }

            if (lastIndexOfOne >= 0) {
                break;
            }else{
                lastIndexOfOne = numberOfRows-1;
                firstValidColumn++;
            }
        }

        int prev;
        for (int col=firstValidColumn;col<numberOfCols;col++){
            prev = lastIndexOfOne;
            lastIndexOfOne = groupAllOnes(input,array,lastIndexOfOne,col);
            if(lastIndexOfOne<0){
                lastIndexOfOne = prev;
            }
        }

        int smalletIndex = array[0];
        for(int i =0;i<lastIndexOfOne;i++){
            if(array[i]<smalletIndex){
                smalletIndex = array[i];
            }
        }
        return smalletIndex;
    }

    private static int groupAllOnes(int[][] input, int[] array, int lastIndexOfOne , int col) {

        while (lastIndexOfOne>=0 && input[array[lastIndexOfOne]][col] <= 0) {
            lastIndexOfOne--;
        }

        if(lastIndexOfOne<0){
            return lastIndexOfOne;
        }

        for(int i= 0;i<=lastIndexOfOne;i++){

            if(input[array[i]][col] <= 0){
                ArrayUtility.swap(array,i,lastIndexOfOne);
                lastIndexOfOne--;
            }
        }
        return lastIndexOfOne;
    }
}
