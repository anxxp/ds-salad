package Matrix;

public class SearchInSortedMatrix {

    public static void main(String args[]){

        int[][] matrix = { {10, 20, 30, 40},
                           {15, 25, 35, 45},
                           {27, 29, 37, 48},
                           {32, 33, 39, 50}
                         };


        System.out.println(searchNum(matrix,32));

    }

    private static boolean searchNum(int[][] matrix, int num) {
        int rowindex = 0;
        int colIndex = matrix[0].length-1;
        int totalRows = matrix.length;

        while(rowindex<totalRows && colIndex>=0){

            int current = matrix[rowindex][colIndex];
            if( current == num){
                return  true;
            }else if(num < current){
                colIndex--;
            }else{
                rowindex++;
            }
        }
        return false;
    }
}
