package Practice;

public class KadanesAlgo {

    public static void main(String args[]){
        int[] input = {-3,4,5,-1,2,-50,-100};
        System.out.println(maxContiguousSum(input));

    }

    private static int maxContiguousSum(int[] input) {

        if(input == null || input.length==0){
            throw new IllegalArgumentException();
        }

        int maxSumEndingHere = input[0];
        int maxSumSoFar = input[0];


        for (int i =1 ;i<input.length;i++){

            maxSumEndingHere += input[i];
            if(maxSumEndingHere<0){
                maxSumEndingHere=0;

            }

            if(maxSumEndingHere>maxSumSoFar){
                maxSumSoFar = maxSumEndingHere;
            }
        }

        return maxSumSoFar;
    }
}
