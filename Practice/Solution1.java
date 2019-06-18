/*
package Practice;// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution1
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
        // WRITE YOUR CODE HERE
        int[][] visited = new int[area.size()][area.get(0).size()];

        Solution1.searchTarget(numRows,numColumns,area,visited);
    }
    // METHOD SIGNATURE ENDS

    public static int searchTarget(int rowIndex, int colIndex,List<List<Integer>> inputMaze, int[][] visitedMaze){

        if(!isValidCell(rowIndex,colIndex,inputMaze) || isVisited(rowIndex,colIndex,visitedMaze)){
            return Integer.MAX_VALUE;
        }

        if(inputMaze.get(rowIndex).get(colIndex) == 9){
            return 0;
        }

        //Marking as visited
        visitedMaze[rowIndex][colIndex] = 1;
        //left
        int leftpathDistance = searchTraget(rowIndex,colIndex-1,inputMaze,visitedMaze);
        //right
        int rightPathDistance = searchTraget(rowIndex,colIndex+1,inputMaze,visitedMaze);
        //up
        int upPathDistance = searchTraget(rowIndex-1,colIndex,inputMaze,visitedMaze);
        //down
        int downPathDistance = searchTraget(rowIndex+1,colIndex,inputMaze,visitedMaze);
        //Undo the visit
        visitedMaze[rowIndex][colIndex] = 0;

        int minDistance = Math.min(Math.min(leftpathDistance,rightPathDistance),Math.min(upPathDistance,downPathDistance));

        return minDistance==Integer.MAX_VALUE ? Integer.MAX_VALUE : minDistance+1;

    }

    public static boolean isVisited(int rowIndex, int colIndex,int[][] visitedMaze){
        return visitedMaze[rowIndex][colIndex] == 1;
    }

    public static boolean isValidCell(int rowIndex, int colIndex,List<List<Integer>> inputMaze){

        return (rowIndex >=0 &&
                rowIndex < inputMaze.size() &&
                colIndex >=0 &&
                colIndex < inputMaze.get(0).size() &&
                inputMaze.get(rowIndex).get(colIndex) !=null
        );
    }
}*/
