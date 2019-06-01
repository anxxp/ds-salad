package Array;

public class FindMaxInSortedRotatedArray {

    public static void main(String args[]){

        int[] input = {4,5,11,12,30};

        System.out.println(maxInSortedRotatedArray(input));
        System.out.println(maxInSortedRotatedArray2(input));
    }

    private static int maxInSortedRotatedArray(int[] input) {

        if(input.length == 0){
            throw new IllegalArgumentException();
        }

        int start = 0;
        int end = input.length-1;
        int mid;

        while(start<=end){

            if(start==end){
                return input[start];
            }

            if(end-start == 1 ){
                return Math.max(input[start],input[end]);
            }

            mid = (start + end)/2;

            if(input[mid]>input[mid-1] && input[mid]>input[mid+1]){
                return input[mid];
            }else if(input[mid]>input[0]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return Integer.MIN_VALUE;
    }

    private static int maxInSortedRotatedArray2(int[] input) {

        if(input.length == 0){
            throw new IllegalArgumentException();
        }

        if(input.length == 1){
            return input[0];
        }

        int start=0;
        int end = input.length-1;
        int mid;

        while(start < end-1){
            mid = (start+end)/2;
            if(input[mid] > input[mid+1]){
                return input[mid];
            }

            if(input[mid]> input[0]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }


        return Math.max(input[start],input[end]);
    }
}
