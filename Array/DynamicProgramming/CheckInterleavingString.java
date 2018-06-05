package Array.DynamicProgramming;

public class CheckInterleavingString {

  public static void main(String args[]) {
    String firstStr = "bcc";
    String secondStr = "bbca";
    String thirdStr = "bbcbcac";

    System.out.println(
        "The first and second string interleave to form third string : "
            + checkInterleavingString(firstStr, secondStr, thirdStr));
  }

  public static boolean checkInterleavingString(
      String firstStr, String secondStr, String thirdStr) {
    boolean isInteleavingStr = false;
    int FSL = firstStr.length();
    int SSL = secondStr.length();
    int TSL = thirdStr.length();

    if (FSL + SSL != TSL) {
      return isInteleavingStr;
    }

    boolean matrix[][] = new boolean[FSL + 1][SSL + 1];
    /*Set the matrix[0][0]= true , as matrix[0][0] represents that 'No characters of first string' and
     * 'Empty first string' and 'Empty second string'
     * will successfully form the 'Empty third string'
     * */
    matrix[0][0] = true;

    /*
     * Populate the first column, this imitates the case when second string is empty
     * */
    for (int i = 1; i <= FSL; i++) {
      if (firstStr.charAt(i - 1) == thirdStr.charAt(i - 1)) {
        matrix[i][0] = matrix[i - 1][0];
      } else {
        matrix[i][0] = false;
      }
    }
    /*
     * Populate the first row, this imitates the case when first string is empty
     * */
    for (int j = 1; j <= SSL; j++) {
      if (secondStr.charAt(j - 1) == thirdStr.charAt(j - 1)) {
        matrix[0][j] = matrix[0][j - 1];
      } else {
        matrix[0][j] = false;
      }
    }
    /*
     * 1. Current character of thirdStr is neither equal to current character of firstStr nor of secondStr
     * 2. Current character of thirdStr is equal to current character of firstStr and secondStr both
     * 3. Current character of the thirdStr is equal to the current character of firstStr and not of secondStr
     * 4. Current character of the thirdStr is equal to the current character of secondStr and not of the the firstStr
     * **/
    for (int i = 1; i <= FSL; i++) {
      for (int j = 1; j <= SSL; j++) {
        if (firstStr.charAt(i - 1) != thirdStr.charAt(i + j - 1)
            && secondStr.charAt(j - 1) != thirdStr.charAt(i + j - 1)) {
          matrix[i][j] = false;
        } else if (firstStr.charAt(i - 1) == thirdStr.charAt(i + j - 1)
            && secondStr.charAt(j - 1) == thirdStr.charAt(i + j - 1)) {
          matrix[i][j] = matrix[i - 1][j] || matrix[i][j - 1];
        } else if (firstStr.charAt(i - 1) == thirdStr.charAt(i + j - 1)) {
          matrix[i][j] = matrix[i - 1][j];
        } else if (secondStr.charAt(j - 1) == thirdStr.charAt(i + j - 1)) {
          matrix[i][j] = matrix[i][j - 1];
        } else {
          matrix[i][j] = false;
        }
      }
    }

    // Print the resultant DP matrix for debugging
    System.out.println("--------------------The DP Matrix--------------------");
    System.out.println();
    for (int i = 0; i < FSL + 1; i++) {
      for (int j = 0; j < SSL + 1; j++) {
        System.out.print((matrix[i][j] == true) ? matrix[i][j] + "  |" : matrix[i][j] + " |");
      }
      System.out.println("");
    }
    System.out.println();
    // The DP Matrix printing ends here

    isInteleavingStr = matrix[FSL][SSL];
    return isInteleavingStr;
  }
}
