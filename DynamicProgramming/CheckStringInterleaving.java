package DynamicProgramming;

public class CheckStringInterleaving {

    public static void main(String a[]){

        String firstStr = "bbc";
        String secondStr = "bbca";
        String thirdStr =  "bbcbcac";

        System.out.println(firstStr+" and "+secondStr+" interleaves to form "+thirdStr+" is "+checkStringInterleving(firstStr,secondStr,thirdStr));
    }

    public static boolean checkStringInterleving(String firstStr, String secondStr,String thirdStr){
        int firstStrLen = firstStr.length();
        int secondStrLen = secondStr.length();
        int thirdStrLen = thirdStr.length();

        boolean  isStringInterleaving = false;

        if(firstStrLen+secondStrLen != thirdStrLen){
            return isStringInterleaving;
        }

        boolean[][] matrix  = new boolean[firstStrLen+1][secondStrLen+1];
        matrix[0][0] = true;

        for(int i=1;i<=firstStrLen;i++){
            if(firstStr.charAt(i-1) == thirdStr.charAt(i-1)){
                matrix[i][0] = matrix[i-1][0];
            }else{
                matrix[i][0] = false;
            }
        }

        for(int j=1;j<=secondStrLen;j++){
            if(secondStr.charAt(j-1)== thirdStr.charAt(j-1)){
                matrix[0][j] = matrix[0][j-1];
            }else{
                matrix[0][j]= false;
            }
        }


        return isStringInterleaving;
    }
}
