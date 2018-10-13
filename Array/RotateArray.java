package Array;

import static Array.ArrayUtility.swap;

public class RotateArray {

    public static void main(String args[]){
        int input[] ={4,7,3,9,7,1,2};
        int numberOfShifts = 3;
        int numberOfElements = input.length;

        ArrayUtility.printArray("INPUT",input);
        rotateArray(input,numberOfShifts,numberOfElements);
        ArrayUtility.printArray("OUTPUT",input);
    }

    private static void rotateArray(int[] input, int numberOfShifts, int numberOfElements) {
        /*reverse(input,0,numberOfShifts-1);
        reverse(input,numberOfShifts,numberOfElements-1);
        reverse(input,0,numberOfElements-1);*/

        reverse(input,0,numberOfElements-numberOfShifts-1);
        reverse(input,numberOfShifts,numberOfElements-1);
        reverse(input,0,numberOfElements-1);
    }

    private static void reverse(int[] input, int start, int end) {

        while(start < end){
            swap(input,start,end);
            start++;
            end--;
        }
    }
}
