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

        /**
         * There are two optimizations that we can do while creating the array
         * 1. If the total number of characters in the input string is
         *      less than 127 then, we can use
         *      byte[] count = new byte[128]; byte 1 byte  -128 to 127
         *      less than 32,767 then , we can use
         *      short[] count = new short[128];
         *
         * 2. If we know the character set
         *      if only alphabets and all in lower case then
         *      array of size 26 is only needed and we can calculate
         *      the index in the array by subtracting 97; as a->97 in ASCII
         * */
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
