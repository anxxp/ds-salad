package Matrix;
/**
 * Set the respective row and the column to 0 if a given cell is 0.
 * */
public class ZeroMatrix {

    public static void main(String args[]){

        int[][] matrix = {
                {1,0,3,5,0},
                {8,2,0,1,0},
                {1,2,3,4,5},
                {5,5,5,5,5}
        };

        System.out.println("---------------INPUT MATRIX ---------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print((matrix[i][j] < 10) ? matrix[i][j] + "  " : matrix[i][j] + " ");
            }
            System.out.println("");
        }

        convertIntoZeroMatrix(matrix);
        System.out.println("---------------ZERO MATRIX ---------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print((matrix[i][j] < 10) ? matrix[i][j] + "  " : matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static void convertIntoZeroMatrix(int[][] matrix) {

        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;
        int totalRows = matrix.length;
        int totalCols = matrix[0].length;
        /**
         * iterate the first row and set flag if there exist a zero element
         * */
        for(int i= 0 ; i< totalCols;i++){

            if(matrix[0][i] == 0){
                isFirstRowZero = true;
                break;
            }
        }
        /**
         * iterate the first col and set flag if there exist a zero element
         * */
        for(int i= 0 ; i< totalRows;i++){

            if(matrix[i][0] == 0){
                isFirstColZero = true;
                break;
            }
        }
        /**
         * Iterate rest of the cells.
         * If a zero elemnt is found the set the  corresponding cell
         * in first row and first col as 0.
         * NOTE : We are using the first row and column  to remember
         * if visited any zero cell.
         * */
        for(int row = 1 ;row < totalRows;row++){
            for(int col =1;col< totalCols;col++){
                if(matrix[row][col] == 0){
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        /**
         * iterate the first row and set entire column as zero if we come across
         * a zero.
         * */
        for(int col= 0 ; col< totalCols;col++){

            if(matrix[0][col] == 0){
             setZeroCol(matrix,col);
            }
        }
        /**
         * iterate the first col and set entire row as zero if we come across
         * a zero.
         * */
        for(int row= 0 ; row< totalRows;row++){

            if(matrix[row][0] == 0){
                setZeroRow(matrix,row);
            }
        }
        /**
         * Now we check if the initial matrix had zero in its first row.
         * If yes then we set the first row as zero
         * */
        if(isFirstRowZero){
            setZeroRow(matrix,0);
        }
        /**
         * Now we check if the initial matrix had zero in its first col.
         * If yes then we set the first col as zero
         * */
        if(isFirstColZero){
            setZeroCol(matrix,0);
        }
    }

    private static void setZeroCol(int[][] matrix, int col) {
        int totalRows = matrix.length;
        for(int i= 0 ; i< totalRows;i++){
            matrix[i][col] = 0;
        }
    }

    private static void setZeroRow(int[][] matrix, int row) {
        int totalCol = matrix[0].length;
        for(int i= 0 ; i< totalCol;i++){
            matrix[row][i] = 0;
        }
    }
}
