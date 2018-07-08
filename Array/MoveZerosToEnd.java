package Array;

public class MoveZerosToEnd {

    public static void main(String ags[]){
        int[] input = {1,0,2,5,0,0,7,5,0,8,4};
        ArrayUtility.printArray("INPUT",input);

        moveZerosToEnd(input);

        ArrayUtility.printArray("OUTPUT",input);
    }

    public static void moveZerosToEnd(int[] input){

        int lastIndexForZero=input.length-1;
        int currentIndex=0;
        while(input[lastIndexForZero] ==0 ){
            lastIndexForZero--;
        }
        while(lastIndexForZero > currentIndex){

            if(input[currentIndex] == 0){

                ArrayUtility.swap(input,currentIndex,lastIndexForZero);

                while(input[lastIndexForZero] == 0){
                    lastIndexForZero--;
                }
            }
            currentIndex++;
        }
    }


}
