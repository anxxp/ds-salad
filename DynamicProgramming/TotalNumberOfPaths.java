package DynamicProgramming;

/**
 * PROBLEM :
 *
 * The problem is to count all the possible paths from top left to bottom right of a M x N matrix
 * with the constraints that from each cell you can either move only to right or down.
 *
 * */
public class TotalNumberOfPaths {

    public static void main(String args[]){
        int numberOfRows = 5;
        int numberOfColumns = 8;

        System.out.println("Number of paths from top-left to bottom-right : "+totalNumberOfPaths(numberOfRows,numberOfColumns));
    }

    private static int totalNumberOfPaths(int numberOfRows, int numberOfColumns) {

        int numberOfPaths[][] = new int[numberOfRows][numberOfColumns];

        numberOfPaths[0][0] = 0;

        for (int i=1;i<numberOfColumns;i++){
            numberOfPaths[0][i] = 1;
        }

        for (int i=1;i<numberOfRows;i++){
            numberOfPaths[i][0] = 1;
        }

        for(int i=1;i<numberOfRows;i++){
            for(int j=1;j<numberOfColumns;j++){
                numberOfPaths[i][j] = numberOfPaths[i-1][j] + numberOfPaths[i][j-1];
            }
        }
        return numberOfPaths[numberOfRows-1][numberOfColumns-1];
    }
}
