package Recursion;

import java.util.ArrayList;

public class AllCombination {

    public static void main(String args[]){
        int[] input = {1,2,3};
        ArrayList<Integer> result = new ArrayList<>(input.length);
        printAllCombination(input,0,result);
    }

    private static void printAllCombination(int[] input, int index, ArrayList<Integer> result){

        if(index == input.length){
            result.forEach(integer -> System.out.print(integer+" "));
            System.out.println();
            return;
        }

        result.add(input[index]);
        printAllCombination(input,index+1,result);
        result.remove(result.size()-1);
        printAllCombination(input,index+1,result);
    }
}
