package Array;

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
        while(nextIndexToSwapZero > currentIndex){

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
