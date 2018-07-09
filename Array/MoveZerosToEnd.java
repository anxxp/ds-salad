package Array;
/**
 * PROBLEM :
 * Given an array, we need to move all 0s if any to the right
 * end of the array.
 *
 * SOLUTION :
 *  We find the last index from the END with a NON-ZERO element.
 *  This index will be used to SWAP elements with the index
 *  of the FIRST ZERO we find from the START while iterating
 *  over the array.
 *  Once we SWAP the elements in the above indices, we mark
 *  the immediate LEFT index of the element with ZERO as the next eligible
 *  index to store the newly found ZERO if any.
 *
 *  This we continue till
 *    currentIndex < nextIndexToSwapZero  , is TRUE
 *    When the above condition is FALSE, then all
 *    the elements from that index to the END of the
 *    array are all ZEROS. So no need to further iterate.
 *
 * */
public class MoveZerosToEnd {

    public static void main(String ags[]){
        int[] input = {1,0,2,5,0,0,7,5,0,8,4};
        ArrayUtility.printArray("INPUT",input);

        moveZerosToEnd(input);

        ArrayUtility.printArray("OUTPUT",input);
    }

    public static void moveZerosToEnd(int[] input){

        int nextIndexToSwapZero=input.length-1;
        int currentIndex=0;
        while(input[nextIndexToSwapZero] ==0 ){
            nextIndexToSwapZero--;
        }
        while(currentIndex < nextIndexToSwapZero ){

            if(input[currentIndex] == 0){

                ArrayUtility.swap(input,currentIndex,nextIndexToSwapZero);

                while(input[nextIndexToSwapZero] == 0){
                    nextIndexToSwapZero--;
                }
            }
            currentIndex++;
        }
    }


}
