package Backtracking;

public class MinDistanceToTargetWhenUpDownRightLeftAllowed {

    int[][] inputMaze;
    int target;
    int totalRows;
    int totalColumns;
    int[][] visitedMaze;

    public MinDistanceToTargetWhenUpDownRightLeftAllowed(int[][] inputMaze,int target){

        this.inputMaze = inputMaze;
        this.totalRows = inputMaze.length;
        this.totalColumns = inputMaze[0].length;
        this.visitedMaze = new int[totalRows][totalColumns];
        this.target =target;
    }
    public static void main(String args[]){
        /**
        * Let us assume that we are give an inputMaze.
         * 1 ->  suggests a path
         * 0 ->  suggests an obstacle
         * 10 -> is the TARGET
        */
        int[][] inputMaze = new int[][]{
                {1, 1, 0, 10},
                {0, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 1, 1, 1}
        };
        MinDistanceToTargetWhenUpDownRightLeftAllowed minDistanceToTarget = new MinDistanceToTargetWhenUpDownRightLeftAllowed(inputMaze,10);
        System.out.println();
        minDistanceToTarget.minimumDistanceToTarget();
    }

     void minimumDistanceToTarget() {

        int minimumDistanceToTarget = searchTarget(0,0);

        if(minimumDistanceToTarget == Integer.MAX_VALUE){
            System.out.println("The TARGET is not reachable...Send in Helicopter");
        }else{
            System.out.println("TARGET taken down in "+minimumDistanceToTarget+" moves");
        }

    }

    private int searchTarget(int rowIndex ,int colIndex) {

        if(!isValidCell(rowIndex,colIndex) || isVisited(rowIndex,colIndex)){
            return Integer.MAX_VALUE;
        }

        if(inputMaze[rowIndex][colIndex] == target){
            return 0;
        }

        visitedMaze[rowIndex][colIndex] = 1;
        int leftPathDistance = searchTarget(rowIndex,colIndex-1);
        int rightPathDistance = searchTarget(rowIndex,colIndex+1);
        int upPathDistance = searchTarget(rowIndex-1,colIndex);
        int downPathDistance = searchTarget(rowIndex+1,colIndex);
        visitedMaze[rowIndex][colIndex] = 0;
        int minDistance =  minOf(leftPathDistance,rightPathDistance,upPathDistance,downPathDistance);
        return minDistance == Integer.MAX_VALUE ? Integer.MAX_VALUE : minDistance+1;
    }

    private boolean isVisited(int rowIndex, int colIndex) {
        return visitedMaze[rowIndex][colIndex] == 1;
    }

    private int minOf(int a, int b, int c, int d) {
        return Math.min(Math.min(a,b),Math.min(c,d));
    }

    private boolean isValidCell(int rowIndex ,int colIndex){
        return (rowIndex>=0 &&
                rowIndex <totalRows &&
                colIndex >=0 &&
                colIndex <totalColumns &&
                inputMaze[rowIndex][colIndex] !=0);
    }
}
