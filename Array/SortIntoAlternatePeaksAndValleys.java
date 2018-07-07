package Array;

/**
 * This problem is also known as Zig-zag array
 *
 * PROBLEM :
 *
 * We need to sort a given array of numbers into alternte peaks and valleys.
 * A peak is an index in the array such that A[i-1] <= A[i] >= A[i+1]
 * A valley is an index in the array such that A[i-1] >= A[i] <= A[i+1]
 *
 * SOLUTION :
 *
 * We could solve this problem maintaining a TOGGLING FLIP-FLOP variable.
 *
 * When the variable is SET then we check for :
 *                          Current Element GREATER THAN EQUAL  Next Element (say).
 *                          i-e  A[i] >= A[i+1]
 * And when it is NOT SET then we check for :
*                           Current Element  LESSER THAN EQUAL Next Element .
*                           i-e  A[i] <= A[i+1]
 *
 * If any of the case gives FALSE we SWAP the CURRENT with the NEXT element.
 * */
public class SortIntoAlternatePeaksAndValleys {

    public static void main(String args[]){

        int[] input = {5,7,9,6,2,11,8,1};
        System.out.print("INPUT : ");
        for (int num : input){
            System.out.print(num+" ");
        }
        System.out.println();
        sortIntoAlternatePeaksAndValleys(input);
        System.out.print("OUTPUT : ");
        for (int num : input){
            System.out.print(num+" ");
        }
    }

    public static void sortIntoAlternatePeaksAndValleys(int[] input){

        boolean flipFlop = true;
        int lastIndex = input.length-1;
        for(int i = 0; i<= lastIndex-1 ;i++){

            if(flipFlop){
                if(input[i]>input[i+1]){
                    swap(input,i,i+1);
                }
            }else{
                if(input[i]<input[i+1]){
                    swap(input,i,i+1);
                }
            }

            flipFlop = !flipFlop;
        }
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[i+1] = temp;
    }
}








