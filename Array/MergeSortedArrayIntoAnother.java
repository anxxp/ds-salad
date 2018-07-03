package Array;

/**
 * PROBLEM : We have two Sorted Arrays namely , A and B.
 * Assume A is sufficiently large to accommodate all the
 * elements of B along with its own.
 * Write a program to merge both them into A as sorted array.
 *
 * SOLUTION : The trick here is, if we start merging from the
 * front (beginning of A) then we to move the elements to accommodate
 * the elements of B. It would be smart if we start from the last element
 * of the Merged array.
 *
 * Index of the last element of the merged Array =
 *      Number of Elements (A) + Number of Elements (B) - 1 ;
 *
 * Start from the end and merge as we normally do :)
 *
 * NOTE : This tweak only helps if we are to store the sorted-merge-array
 * in any of the given input Array.
 * If we create a new array to store output then we could start from
 * beginning or end, would not make difference either way.
 *
 * */
public class MergeSortedArrayIntoAnother {

    public static void main(String args[]){
        int [] A = new int[10];
        int [] B = new int[4];

        A[0]=2;A[1]=5;A[2]=6;A[3]=9;A[4]=15;
        B[0]=1;B[1]=4;B[2]=7;B[3]=12;

        int numA = 5;
        int numB = 4;

        mergeSortedArrayIntoAnother(A,B,numA,numB);

    }

    public static void mergeSortedArrayIntoAnother(int A[],int B[],int numA,int numB){

        int indexMerged = numA+numB-1; // This would the index of last element in the sorted merged Array
        int indexA = numA-1;
        int indexB = numB-1;

        while(indexB >=0){

            if(indexA>=0 && A[indexA] >= B[indexB]){
                A[indexMerged--] = A[indexA--];
            }else{
                A[indexMerged--] = B[indexB--];
            }
        }

        for (int i= 0 ; i< numA+numB;i++){
            System.out.print(A[i]+" ");
        }
    }
}
