package Matrix;

import Array.ArrayUtility;
/**
 * PROBLEM :
 * Each row is a binary representation of a number.
 * We need to find the row-index of the largest number among these.
 * If there are multiple rows with the largest number then we need
 * to find the row with smallest index.
 *
 * */
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
         * Array to keep track of indices of rows.This would help to know the row
         * indices after we group the rows with 1 for any specific column.
         * */
        int array[] = new int[numberOfRows];
        for (int i = 0; i < numberOfRows; i++) {
            array[i] = i;
        }

        /**
         * We try to find the index of the last row with 1 in column 0.
         * If we dont have 1 in 0th column then we check in subsequent column
         * till we find the column with 1.
         * The above column would be assigned to 'firstValidColumn'
         * and the row index of last 1 will be assigned to 'lastIndexOfOne'
         * */
        int lastIndexOfOne = numberOfRows - 1;
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

        /**
         *
         * For each column from the firstValidColumn to the last column,
         * we try to group all the rows with 1 in that column together
         * in beginning of the array. (remember,the array holds the row indices).
         *
         * NOTE :
         * In the firstValidColumn we will have the index of all the rows
         * with 1 grouped together from the beginning.Then each iteration for the
         * subsequent column we narrow down that sub-array.
         *
         * If for any particular column there is no 1 then we don't remove all the element
         * from the sub-array but instead reset the sub-array to the previous iteration.
         *
         * */
        int prev;
        for (int col=firstValidColumn;col<numberOfCols;col++){
            prev = lastIndexOfOne;
            lastIndexOfOne = groupAllOnes(input,array,lastIndexOfOne,col);
            if(lastIndexOfOne<0){
                lastIndexOfOne = prev;
            }
        }
        /**
         * When we are done will all the columns then,
         * we will have only the row-index largest number row.
         * If there are more than one element the array i-e
         * more than one row will have same number.
         * In such cases we return the smallest row-index among them.
         * */
        int smallestIndex = array[0];
        for(int i =0;i<lastIndexOfOne;i++){
            if(array[i]<smallestIndex){
                smallestIndex = array[i];
            }
        }
        return smallestIndex;
    }

    private static int groupAllOnes(int[][] input, int[] array, int lastIndexOfOne , int col) {

        /**
         * We try to find the last row with 1.
         * */
        while (lastIndexOfOne>=0 && input[array[lastIndexOfOne]][col] <= 0) {
            lastIndexOfOne--;
        }
        /**
         * If last index of 1 came out to be -1 then there are no 1s in that column.
         * We just return -1 in such case.
         * */
        if(lastIndexOfOne<0){
            return lastIndexOfOne;
        }
        /**
         * We traverse the column from the first row and
         * whenever we found 0,we swap the
         * indices with the lastIndexOfOne and decrement the lastIndexOfOne.
         * */
        for(int i= 0;i<=lastIndexOfOne;i++){

            if(input[array[i]][col] <= 0){
                ArrayUtility.swap(array,i,lastIndexOfOne);
                lastIndexOfOne--;
            }
        }
        /**
         * In the end array from index 0 to lastIndexOfOne
         * will have the indices of rows with 1 for this column.
         * */
        return lastIndexOfOne;
    }
}
