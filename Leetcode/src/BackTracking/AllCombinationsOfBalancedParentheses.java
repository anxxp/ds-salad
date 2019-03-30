package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Question : 22
 * Generate Parentheses
 * <p>
 * Given n pairs of parentheses,
 * write a function to generate all combinations
 * of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class AllCombinationsOfBalancedParentheses {
    private static List<String> allBalancedCombinations = new ArrayList<>();
    private static int numberOfPairs;

    public static void main(String args[]) {

        numberOfPairs = 3;
        char[] combinationStr = new char[2 * numberOfPairs];
        findAllCombinationOfBalancedParentheses(0, 0, combinationStr);

        for (String validCombination : allBalancedCombinations) {

            System.out.println(validCombination);
        }

    }

    private static void findAllCombinationOfBalancedParentheses(int numOfOpeningParentheses,
                                                                int numOfClosingParentheses,
                                                                char[] combinationStr) {

        if (numOfOpeningParentheses == numberOfPairs &&
                numOfClosingParentheses == numberOfPairs) {

            allBalancedCombinations.add(new String(combinationStr));
        }


        if (numOfOpeningParentheses < numberOfPairs) {
            combinationStr[numOfOpeningParentheses + numOfClosingParentheses] = '(';
            findAllCombinationOfBalancedParentheses(
                    numOfOpeningParentheses + 1,
                    numOfClosingParentheses,
                    combinationStr
            );
        }

        if (numOfClosingParentheses < numOfOpeningParentheses) {
            combinationStr[numOfOpeningParentheses + numOfClosingParentheses] = ')';
            findAllCombinationOfBalancedParentheses(
                    numOfOpeningParentheses,
                    numOfClosingParentheses + 1,
                    combinationStr
            );
        }
    }


}
