package Array;

/**
 * PROBLEM :
 *
 * Given a array of positive and negative numbers,we need to arrange the
 * array into alternate positive and negative numbers.We also need to preserve
 * the relative ordering of negative and positive numbers.
 * i-e the order of negative numbers in output remains the same as input.
 * This also applies to the positive numbers.
 *
 * SOLUTION :
 *
 * - We iterate through each of the element in the array and check if the
 * EVEN positions have POSITIVE number and ODD positions have NEGATIVE number.
 *
 * - When ever we find and exception, we iterate through the array from the next
 * index to find and element with opposite sign.
 *
 * - We RIGHT-ROTATE the elements between the CURRENT's index and NEXT-OPP-SIGN-ELEMENT's index,
 *  inclusive of both the index. This helps us put the NEXT-OPP-SIGN-ELEMENT in
 *  CURRENT's index and still preserve the order.
 *
 *  NOTE :
 *  If ordering was not important then we could have
 *  just swapped the element in those positions.
 *
 */

public class RearrangeAlternatePositiveNegative {

    public static void main(String args[]){

        int[] input = {5,7,-5,-9,3,4,-2,2};
        ArrayUtility.printArray("INPUT : ",input);
        rearrangeAltPositiveNegative(input);
        ArrayUtility.printArray("OUTPUT : ",input);

    }

    public static void rearrangeAltPositiveNegative(int[] input){
        /**
         * To keep track of the odd and even positions.
         * This toggles in each iteration
         */
        boolean isEvenPosition =true;

        for(int current =0;current < input.length;current++){
            /**
             * When we are EVEN index then we check if the
             * value at this index is NEGATIVE.
             * If TRUE, means we need to replace the element
             * at this index with a POSITIVE number.
             * We search for a POSITIVE number in the rest of the array.
             * Once found we RIGHT-ROTATE the elements between these indices.
             *
             * NOTE : We RIGHT-ROTATE only if indexOfNextPositiveNum is a valid index.
             *      i-e its withing the bound of the array
             * */
            if(isEvenPosition && input[current] < 0 ){
                int indexOfNextPositiveNum =current + 1;

                 while(indexOfNextPositiveNum < input.length && input[indexOfNextPositiveNum]<0){
                     indexOfNextPositiveNum++;
                 }

                 if(indexOfNextPositiveNum < input.length){

                     rightRotate(input,current,indexOfNextPositiveNum);
                 }
            }

            /**
             * When we are ODD index then we check if the
             * value at this index is POSITIVE.
             * If TRUE, means we need to replace the element
             * at this index with a NEGATIVE number.
             * We search for a NEGATIVE number in the rest of the array.
             * Once found we RIGHT-ROTATE the elements between these indices.
             *
             * NOTE : We RIGHT-ROTATE only if indexOfNextNegativeNum is a valid index.
             *      i-e its withing the bound of the array
             * */
            if(!isEvenPosition && input[current] >= 0 ){
                int indexOfNextNegativeNum =current+1;

                while(indexOfNextNegativeNum < input.length && input[indexOfNextNegativeNum]>=0){
                    indexOfNextNegativeNum++;
                }

                if(indexOfNextNegativeNum < input.length){

                    rightRotate(input,current,indexOfNextNegativeNum);
                }
            }

            /**
             * We toggle the isEvenPosition .This mechanism helps us
             * to have isEvenPosition flag TRUE in alternate iterations.
             * */
            isEvenPosition = !isEvenPosition;
        }
    }


/**
 * To RIGHT-ROTATE we copy the previous element in the current index
 * start from the END of the array till an index greater than START.
 * and finally we put the element initially present in the END index to
 * the START index.
 * */
    public static void rightRotate(int[] input, int start, int end){

        int endNum = input[end];

        for(int i=end; i>start ; i--){
            input[i] = input[i-1];
        }
        input[start] = endNum;
    }
}
