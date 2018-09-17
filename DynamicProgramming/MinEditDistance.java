package DynamicProgramming;
/**
 * PROBLEM:
 *
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 *  1. Insert
 *  2. Remove
 *  3.Replace
 *
 *
 * */
public class MinEditDistance {

    public static void main(String args[]){

        //String str1 = "failure";
        //String str2 = "failure";
        //String str1 = "sunday";
        //String str2 = "monday";
        String str1 = "failure";
        String str2 = "success";
        System.out.println("Minimum edit distance is : "+minEditDistance(str1,str2));
    }

    public static int minEditDistance(String firstStr,String secondStr){

        int firstStrLen = firstStr.length();
        int secondStrLen = secondStr.length();

        if(firstStrLen == 0 && secondStrLen == 0){
            return 0;
        }else if(firstStrLen == 0){
            return secondStrLen;
        }else if(secondStrLen == 0){
            return firstStrLen;
        }

        int minEditDistance = 0;
        int editDistance[][] = new int[firstStrLen +1][secondStrLen +1];

        /**
         * First row implies the case when first string (source string) is empty.
         * In this case the edit distance to form the distance string will be equal to the
         * length of second string (desired resultant string).
         * */
        for(int i=0;i<=secondStrLen;i++){
            editDistance[0][i] = i;
        }

        /**
        * The first column implies the case when the second string (desired resultant string) is empty.
        */
        for(int i=0;i<=firstStrLen;i++){
            editDistance[i][0] = i;
        }

        for(int i=1;i<=firstStrLen;i++){

            for(int j=1;j<=secondStrLen;j++){

                if(firstStr.charAt(i-1) == secondStr.charAt(j-1)){
                    editDistance[i][j] = editDistance[i-1][j-1];
                }else{
                    editDistance[i][j] = 1 + minimum(   editDistance[i-1][j],
                                                        editDistance[i][j-1],
                                                        editDistance[i-1][j-1]
                                                    );
                }
            }
        }

        return editDistance[firstStrLen][secondStrLen] ;
    }

    private static int minimum(int x, int y, int z) {

        if(x<=y && x<=z){
            return x;
        }else if(y<=x && y<=z){
            return y;
        }
        return z;
    }
}
