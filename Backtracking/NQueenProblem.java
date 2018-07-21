package Backtracking;

import Array.ArrayUtility;
/**
 * PROBLEM :
 *
 * The N queens puzzle is the problem of placing eight chess queens on an N x N chessboard
 * so that no two queens threaten each other.
 * Thus, a solution requires that no two queens share the same row, column, or diagonal.
 * */
public class NQueenProblem {

    public static void main(String args[]){
        int num = 4;
        printNQueenSolution(num);
    }

    private static void printNQueenSolution(int num) {

        int[] colList = new int[num];
        int row =0;
        /**
         * We will place Queen one by one in each column of the first row,
         * and then check for the next rows recursively.
         * */
        for(int i=0;i<num;i++){
            colList[0] = i;
            printNQueenSolution(row+1,colList,num);
        }
    }

    private static void printNQueenSolution(int currentRow, int[] colList,int num) {
        /**
         * If we have reached to a row , with row index one more than the last
         * row index in the (N x N) matrix.Then we print the colList and return.
         * */
        if(currentRow==num){

             for(int i=0;i<num;i++){
                 System.out.print("( "+i+","+colList[i]+" ) ");
             }
             System.out.println();
             return;
        }
        /**
         * We will check the eligibility of each column in the current row (currentRow)
         * */
        for(int currentColumn=0 ; currentColumn<num ; currentColumn++){

            boolean isSafeForQueen = true;
            /**
             * Check if there is a QUEEN in the current column,for any of the previous rows.
             * */
            for(int row=0;row<currentRow;row++) {


                if (currentColumn == colList[row]) {
                    isSafeForQueen=false;
                    break;
                }
            }
            /**
             * Check if the (currentRow,col) share a common diagonal with any of the
             * previously positioned Queens.
             * */
            for(int row=0;row<currentRow;row++) {
                if(Math.abs(currentRow-row) == Math.abs(currentColumn-colList[row])){
                    isSafeForQueen=false;
                    break;
                }
            }
            /**
             * If the current column still stands eligible,
             * then we place Queen in (currentRow,col) and go and check for next row.
             * */
            if(isSafeForQueen){
                colList[currentRow] = currentColumn;
                printNQueenSolution(currentRow+1,colList,num);

            }
        }
    }
}


