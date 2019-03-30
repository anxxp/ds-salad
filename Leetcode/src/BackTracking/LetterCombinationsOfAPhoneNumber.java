package BackTracking;

import java.util.*;

/**
 Question : 17

 Given a string containing digits from 2-9 inclusive,
 return all possible letter combinations that
 the number could represent.

 A mapping of digit to letters
 (just like on the telephone buttons) is given below.
 Note that 1 does not map to any letters.

 1      2      3
        ABC    DEF
 4      5       6
 GHI    JKL    MNO
 7      8       9
 PQRS   TUV    WXYZ


 Example:

 Input: "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:

 Although the above answer is in lexicographical order,
 your answer could be in any order you want.

 */

public class LetterCombinationsOfAPhoneNumber{

    private static Map<Character, List<Character>> keypad = new HashMap();
    private static char[] phoneNum ;
    private static List<StringBuilder> words = new ArrayList<>();

    public static void main (String args[]){

        keypad.put('1', Arrays.asList(' '));
        keypad.put('2', Arrays.asList('A','B','C'));
        keypad.put('3', Arrays.asList('D','E','F'));
        keypad.put('4', Arrays.asList('G','H','I'));
        keypad.put('5', Arrays.asList('J','K','L'));
        keypad.put('6', Arrays.asList('M','N','O'));
        keypad.put('7', Arrays.asList('P','Q','R','S'));
        keypad.put('8', Arrays.asList('T','U','V'));
        keypad.put('9', Arrays.asList('W','X','Y','Z'));

        phoneNum = "25".toCharArray();

        StringBuilder word = new StringBuilder();
        helper(word,0);

        for (StringBuilder w:
             words) {
            System.out.println(w);
        }

    }

    private static void helper(StringBuilder word, int digitIndex ) {

        if(word.length() == phoneNum.length){
            words.add(new StringBuilder(word));
            return;
        }
        for (Character c : keypad.get(phoneNum[digitIndex])) {
            word.append(c);
            helper(word,digitIndex+1);
            word.deleteCharAt(digitIndex);
        }

    }


}
