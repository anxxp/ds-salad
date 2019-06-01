package Backtracking;

import java.util.ArrayList;
import java.util.Iterator;

public class SimpleRatMazeProblem {

    public static void main(String args[]){
        int[][] input = new int[][]{
                        {1, 0, 0, 0},
                        {1, 0, 0, 0},
                        {1, 1, 0, 0},
                        {1, 1, 1, 1}
        };

     printAllThePaths(input);
    }

    private static void printAllThePaths(int[][] input) {

        ArrayList<String> path = new ArrayList<>();
        printAllThePaths(input,0,0,path);
    }

    private static void printAllThePaths(int[][] input, int row, int col,ArrayList path) {

        if(row >= input.length || col>=input[0].length){
            return;
        }
        if(input[row][col]==0){
            return;
        }
        path.add("( "+row+","+col+" ) ->");
        if(row == input.length-1 && col == input[0].length-1){
            Iterator iter = path.iterator();
            while (iter.hasNext()) {
                System.out.print(iter.next());
            }
            System.out.println();
        }
        printAllThePaths(input,row,col+1,path);
        printAllThePaths(input,row+1,col,path);
        path.remove("( "+row+","+col+" ) ->");

    }

}
