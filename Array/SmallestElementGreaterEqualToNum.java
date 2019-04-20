package Array;

public class SmallestElementGreaterEqualToNum {

    public static void main(String args[]){

        int[] input = {10,12,15,18,25,33};
        int num = 5;

        System.out.println(smallestElementGreaterThanEqual(input,num));
    }


    private static int smallestElementGreaterThanEqual(int[] input, int num) {

        if(input == null || input.length == 0){
            throw new IllegalArgumentException();
        }

        int start =0;
        int end = input.length-1;
        int mid;

        while(start+1 < end){
            mid = start + (end - start)/2;

            if(input[mid] >= num && input[mid-1] < num){
                return input[mid];
            }else if(input[mid] > num){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        if(input[start]>= num){
            return input[start];
        }else if(input[end] >=num){
            return input[end];
        }else{
            return Integer.MIN_VALUE;
        }
    }
}
