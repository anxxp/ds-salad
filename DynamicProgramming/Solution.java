package DynamicProgramming;

import java.util.*;

class Result {

    /*
     * Complete the 'largestMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int largestMatrix(List<List<Integer>> arr) {
        // Write your code here
        int rows = arr.size();
        int cols = arr.get(0).size();
        int[][] sub = new int[rows][cols];

        for(int i=0;i<rows;i++){
            sub[i][0] = arr.get(i).get(0);
        }

        for(int i=1; i<rows;i++){
            for(int j=1;j<cols;j++){
                if(arr.get(i).get(j)==1){
                    sub[i][j] = Math.min(sub[i-1][j-1],Math.min(sub[i][j-1],sub[i-1][j]))+1;
                }
                else{
                    sub[i][j]=0;
                }
            }
        }

        int maxSize=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(sub[i][j]>maxSize){
                    maxSize = sub[i][j];
                }
            }
        }
        System.out.println("Test: "+ arr);
        return maxSize;

    }

}

public class Solution {
    public static void main(String[] args)  {


        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        List<Integer> r3 = new ArrayList<>();
        r1.add(1);
        r1.add(1);
        r1.add(1);
        r2.add(1);
        r2.add(1);
        r2.add(0);
        r3.add(1);
        r3.add(0);
        r3.add(1);

        arr.add(r1);
        arr.add(r2);
        arr.add(r3);

        int result = Result.largestMatrix(arr);
        System.out.println(result);

    }
}
