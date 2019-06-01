package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Question : 22
 * Generate Parentheses
 *
 * Given n pairs of parentheses,
 * write a function to generate all combinations
 * of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 */
public class AllCombinationsOfBalancedParentheses {
    private static List<String> allBalancedCombinations = new ArrayList<>();
    private static int desiredNumberOfPairs;

    public static void main(String args[]) {

        desiredNumberOfPairs = 3;
        char[] combinationStr = new char[2 * desiredNumberOfPairs];
        findAllCombinationOfBalancedParentheses(0, 0, combinationStr);

        for (String validCombination : allBalancedCombinations) {

            System.out.println(validCombination);
        }

    }

    private static void findAllCombinationOfBalancedParentheses(int numOfOpeningParentheses,
                                                                int numOfClosingParentheses,
                                                                char[] combinationStr) {

        if (numOfOpeningParentheses == desiredNumberOfPairs &&
                numOfClosingParentheses == desiredNumberOfPairs) {

            allBalancedCombinations.add(new String(combinationStr));
        }

        if (numOfClosingParentheses < numOfOpeningParentheses) {
            combinationStr[numOfOpeningParentheses + numOfClosingParentheses] = ')';
            findAllCombinationOfBalancedParentheses(
                    numOfOpeningParentheses,
                    numOfClosingParentheses + 1,
                    combinationStr
            );
        }

        if (numOfOpeningParentheses < desiredNumberOfPairs) {
            combinationStr[numOfOpeningParentheses + numOfClosingParentheses] = '(';
            findAllCombinationOfBalancedParentheses(
                    numOfOpeningParentheses + 1,
                    numOfClosingParentheses,
                    combinationStr
            );
        }

    }


}
