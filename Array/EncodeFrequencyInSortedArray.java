package Array;

public class EncodeFrequencyInSortedArray {

    public static void main(String args[]){
        int[] inputArray = {1,1,1,3,3,3,3,3,3,4,4,4,5};
        ArrayUtility.printArray("INPUT ARRAY",inputArray);

        encodeFrequencyInSortedArray(inputArray);
    }

    private static void encodeFrequencyInSortedArray(int[] inputArray) {
        int currentIndex = 0;
        int currentNum;
        int lastIndex;
        while(currentIndex<inputArray.length){
            currentNum = inputArray[currentIndex];
            lastIndex = inputArray.length-1;
            lastIndex = binarySearchTheLastIndex(inputArray,currentNum,currentIndex,lastIndex);
            System.out.println(currentNum+""+(lastIndex-currentIndex+1));
            currentIndex = lastIndex+1;
        }
    }

    private static int binarySearchTheLastIndex(int[] inputArray, int currentNum, int lowerIndex, int upperIndex) {

        int mid = (lowerIndex+upperIndex)/2;

        if(inputArray[mid]==currentNum){
            if(mid<inputArray.length-1 && inputArray[mid+1]>currentNum){
                return mid;
            }else if(mid == inputArray.length-1){
                return mid;
            }else{
                return binarySearchTheLastIndex(inputArray,currentNum,mid+1,upperIndex-1);
            }
        }else{
            return binarySearchTheLastIndex(inputArray,currentNum,lowerIndex+1,mid-1);
        }
    }
}
