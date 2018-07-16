package Array;

import static Array.ArrayUtility.swap;
/***
 * PROBLEM :
 *
 * We are given a input string and we are asked to print all the permutations
 * of the characters in it.
 *
 * SOLUTION :
 *
 * We fix the characters till an index and permute the remaining characters.
 * At each recursive call we fix characters till one more index than the
 * previous level.
 *
 * Let us consider an example : ABC
 *
 *        - We fix A at index 0 and permute  [ B,C ]
 *              - We fix B at index 1 and permute [ C ]
 *                         - We fix C at index 2
 *                         - Print ABC
 *
 *              - We fix C at index 1 and permute [ B ]
 *                         - We fix B at index 2
 *                         - Print ACB
 *
 *        - We fix B at index 0 and permute  [ A,C ]
 *              - We fix A at index 1 and permute [ C ]
 *                      - We fix C at index 2
 *                      - Print BAC
 *
 *              - We fix C at index 1 and permute [ A ]
 *                      - We fix A at index 2
 *                      - Print BCA
 *
 *        - We fix C at index 0 and permute  [ A,B ]
 *              - We fix A at index 1 and permute [ B ]
 *                      - We fix B at index 2
 *                      - Print CAB
 *
 *              - We fix B at index 1 and permute [ A ]
 *                      - We fix A at index 2
 *                      - Print CBA
 *
 * */
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

        /**
         * We will fix all elements to the right of startIndex including startIndex
         * one by one at startIndex. We then permute the remaining elements on the right.
         *
         * NOTE :
         * We swap back the elements at the end of each iteration to restore the
         * previous state.
         *
         * */

        for(int i=startIndex;i<=lastIndex;i++){
            swap(input,startIndex,i);
            permute(startIndex+1,input,lastIndex);
            swap(input,startIndex,i);
        }

    }
}
