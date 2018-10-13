package Heap;

public class MinIntHeap {

    private int capacity = 10;
    private int size = 0;
    int[] elements = new int[capacity];

    private int getLeftChildIndex(int parentIndex){
        return 2*parentIndex +1;
    }

    private int getRightChildIndex(int parentIndex){
        return 2*parentIndex+2;
    }

    private int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }

    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index){
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index){
        return getParentIndex(index) >=0;
    }


}
