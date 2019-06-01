package DynamicProgramming;

import java.io.*;
import java.util.ArrayList;
import java.util.List;





public class MaxSquareSubMatrix {
    public static void main(String[] args){


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


        int result = MaxSquareSubMatrix.largestMatrix(arr);
        System.out.println(result);

    }

    public static int largestMatrix(List<List<Integer>>input){
        int rows=input.size();
        int cols=input.get(0).size();
        int[][]sub=new int[rows][cols];
        // copy the first row
        for(int i=0;i<cols; i++){
            sub[0][i]=input.get(0).get(i);
        }
        // copy the first column
        for(int i=0;i<rows; i++){
            sub[i][0]=input.get(i).get(0);
        }

        // for rest of the matrix
        // check if arrA[i][j]==1
        for(int i=1;i<rows; i++){
            for(int j=1;j<cols; j++){
                if(input.get(i).get(j)==1){
                    sub[i][j]=Math.min(sub[i-1][j-1],
                            Math.min(sub[i][j-1],sub[i-1][j]))+1;
                }else{
                    sub[i][j]=0;
                }
            }
        }
        // find the maximum size of sub matrix
        int maxSize=0;
        for(int i=0;i<rows; i++){
            for(int j=0;j<cols; j++){
                if(sub[i][j]>maxSize){
                    maxSize=sub[i][j];
                }
            }
        }
        System.out.println("Maximum size square sub-matrix with all 1s: "+maxSize);
        System.out.println(input);
        return maxSize;
    }
}