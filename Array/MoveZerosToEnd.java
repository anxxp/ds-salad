package Array;

public class MoveZerosToEnd {

    public static void main(String ags[]){
        int[] input = {1,0,2,5,0,0,7,5,0,8,4};
        System.out.print("INPUT : ");
        for (int num : input){
            System.out.print(num+" ");
        }
        System.out.println();
        moveZerosToEnd(input);
        System.out.print("OUTPUT : ");
        for (int num : input){
            System.out.print(num+" ");
        }
    }

    public static void moveZerosToEnd(int[] input){

        int lastIndexForZero=input.length-1;
        int currentIndex=0;
        while(input[lastIndexForZero] ==0 ){
            lastIndexForZero--;
        }
        while(lastIndexForZero > currentIndex){

            if(input[currentIndex] == 0){

                swap(input,currentIndex,lastIndexForZero);

                while(input[lastIndexForZero] == 0){
                    lastIndexForZero--;
                }
            }
            currentIndex++;
        }
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
