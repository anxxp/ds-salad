package Array;

import static Array.ArrayUtility.swap;

public class StringPermutations {

    public static void main(String args[]){

        String input = "123";
        permute(input);
    }

    public static void permute(String input){
        permute(0,input.toCharArray(),input.length()-1);
    }

    public static void permute(int startIndex,char[] input,int lastIndex){

        if(startIndex == lastIndex){
            System.out.println(input);
        }

        for(int i=startIndex;i<=lastIndex;i++){
            swap(input,startIndex,i);
            permute(startIndex+1,input,lastIndex);
            swap(input,startIndex,i);
        }

    }
}
