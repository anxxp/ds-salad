package Array;

public class MinEditDistance {

  public static int  count =0;
  public static void main(String args[]) {
    String firstString = "Anoop";
    String secondString = "oops";
    System.out.println(minEditDistance(firstString,secondString));
  }

  public static int minEditDistance(String firstString, String secondString) {
    if (secondString == null || secondString.length() == 0) {
      return firstString.length();
    }
    if (firstString == null || firstString.length() == 0) {
      return secondString.length();
    }

    //System.out.println("First String : "+firstString+" Second String : "+secondString);
    count = count +min(minEditDistance(
        firstString.substring(0, firstString.length() - 1),
        secondString.substring(0, secondString.length() - 1)),10,10);
    return count;
  }

  public static int min(int num1,int num2,int num3){
      int min = num1;
      if(min>num2){
          min=num2;
      }
      if(min>num3){
          min=num3;
      }
      return min;
  }
}
