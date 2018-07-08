package Array;

public class ArrayUtility {

    public static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void printArray(String prefix,int[] input){
        System.out.print(prefix+" : ");

        for (int i :input) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
