package Array;

public class CheckIfOnePermutationOfOther {

    public static void main(String args[]){
        String inputStr1 = "aaababacc";
        String inputStr2 = "cababaaac";

        System.out.println(isPermutation(inputStr1,inputStr2));
    }

    private static boolean isPermutation(String inputStr1, String inputStr2) {

        if(inputStr1.length() != inputStr2.length()){
            return false;
        }

        int[] count = new int[128];

        for (int i:inputStr1.toCharArray() ) {
            count[i]++;
        }

        for (int j: inputStr2.toCharArray()) {
            count[j]--;
            if(count[j]<0){
                return false;
            }
        }
        return true;
    }
}
