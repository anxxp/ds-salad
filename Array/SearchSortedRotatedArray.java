package Array;

/**
 * PROBLEM : We are given a sorted-rotated-array and asked
 * to find a number in it.
 *
 * SOLUTION :
 *
 * { Array[START] <<< elements in sorted ascending order << Array[X] } GREATER THAN { Array[X+1] << elements in sorted ascending order << Array[END] }
 * In this case X+1 is the inflection point because Array[X] > Array[X+1].
 * This means the Array has two sorted sub-arrays.
 * If MID-POINT <= X , then left part is sorted i-e Array[START] to Array[MID-POINT]
 * Else If MID-POINT >= X+1 , then right part is sorted i-e Array[MID-POINT] to Array[END]
 *
 * We check if the given number belongs to the sorted part.
 * This could be done using the range of the sorted part.
 * If yes, then we search in the sorted part.
 * Else the other part.
 * */
public class SearchSortedRotatedArray {

    public static void main(String args[]){
        int[] inputArray = {48,55,60,10,15,18,25,35,40};
        ArrayUtility.printArray("INPUT ARRAY",inputArray);

        int num =35;
        System.out.println("NUMBER : "+num);

        System.out.println("INDEX : "+searchSortedRotatedArray(inputArray,num));
    }

    public static int searchSortedRotatedArray(int[] input,int num){
        int start =0;
        int end = input.length-1;

        return searchSortedRotatedArray(input,num,start,end);
    }

    public static int searchSortedRotatedArray(int[] input,int num,int start,int end){
        int mid = (start+end)/2;

        if(input[mid]==num){
            return mid;
        }else if(start == end){
            return -1;
        }

        if(input[start]<input[mid] ){
            if(num >= input[start] && num < input[mid]){
                return searchSortedRotatedArray(input,num,start,mid-1);
            }else{
                return searchSortedRotatedArray(input,num,mid,end);
            }
        }

        if(input[mid]<input[end] ){
            if(num > input[mid] && num <=input[end]){
                return searchSortedRotatedArray(input,num,mid+1,end);
            }else{
                return searchSortedRotatedArray(input,num,start,mid);
            }
        }

        return -1;
    }
}
