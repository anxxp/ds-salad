package Array;

public class ClosestSumPairINSortedArray {

    public static void main(String args[]) {

        int[] input = {2, 5, 6, 8, 9, 12, 13, 20};
        int num = 16;
        closestSumPairINSortedArray(input, num);
    }

    private static void closestSumPairINSortedArray(int[] input, int num) {

        int left = 0;
        int right = input.length - 1;
        int indexOne=left;
        int indexTwo=right;
        int closestSum = Integer.MAX_VALUE;
        int currentPairSum;
        while (left < right) {
            currentPairSum = input[left] + input[right];
            if (Math.abs(currentPairSum - num) < closestSum) {
                indexOne =left;
                indexTwo = right;
            }

            if(currentPairSum == num){
                break;
            }else if(currentPairSum<num){
                left++;
            }else{
                right--;
            }
        }

        System.out.println(input[indexOne]+" + "+input[indexTwo] +" is closest to "+num);
    }
}
