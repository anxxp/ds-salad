package Array;

public class SmallestElementGreaterEqualToNum {

    public static void main(String args[]){

        int[] input = {10,12,15,18,25,33};
        int num = 30;

        System.out.println(smallestElementGreaterThanEqual(input,num));
    }

    private static int smallestElementGreaterThanEqual(int[] input, int num) {

        if(input == null || input.length == 0){
            throw new IllegalArgumentException();
        }

        int start =0;
        int end = input.length-1;
        int mid;

        while(start<=end){

            mid = (start+end)/2;

            if(start == end){
                if(input[mid]>=num){
                    return mid;
                }else{
                    return -1;
                }
            }


            if(end == start+1){
                if(input[start]>=num){
                    return start;
                }else if(input[end]>=num){
                    return end;
                }else{
                    return -1;
                }
            }

            if(input[mid]>=num && input[mid-1]<num ){
                return mid;
            }else if(input[mid] > num){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
}
