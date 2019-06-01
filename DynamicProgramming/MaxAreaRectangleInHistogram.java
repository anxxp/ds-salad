package DynamicProgramming;

import java.util.Stack;

/**
 * Given an array representing height of bar in bar graph, find max histogram
 * area in the bar graph. Max histogram will be max rectangular area in the
 * graph.
 */
public class MaxAreaRectangleInHistogram {

    public static void main(String args[]) {
        //int input[] = {1, 3, 5, 3, 2, 2, 3, 3, 1, 0, 3, 6};
        int input[] = {4,2,2,3,1,3,4,5,3};
        int maxArea = maxHistogram(input);
        System.out.println(maxArea);
        maxArea = maxRectangularArea(input);
        System.out.println(maxArea);
        maxArea = maxAreaRectangle(input);
        System.out.println(maxArea);
    }

    public static int maxHistogram(int input[]) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int area;

        stack.push(0);
        int i = 1;

        while (!stack.isEmpty()) {

            if (input[stack.peek()] <= input[i]) {
                stack.push(i);
                if (i <= input.length) {
                    i++;
                }
            } else {
                int top = stack.pop();
                /**
                 * if stack is empty means everything till i has to be
                 * greater or equal to input[top] so get area by
                 * input[top] * i;
                 * */
                if (stack.isEmpty()) {
                    area = input[top] * i;
                }
                /**
                 * if stack is not empty then everything from i-1 to input.peek() + 1
                 * has to be greater or equal to input[top]
                 * so area = input[top]*(i - stack.peek() - 1);
                 * */
                else {
                    area = input[top] * (i - stack.peek() - 1);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static int maxRectangularArea(int[] input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxArea = 0;
        for (int i = 1; i < input.length; i++) {

            if (input[i] > input[stack.peek()]) {
                stack.push(i);
            } else if (input[i] == input[stack.peek()]) {
                /**DO NOTHING*/
            } else if (input[i] < input[stack.peek()]) {

                while (!stack.isEmpty()&& input[stack.peek()] > input[i]) {
                    int temp = stack.pop();
                    int area = 0;
                    area = (i - temp) * input[temp];
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }

                if (stack.isEmpty() || input[stack.peek()] < input[i]) {
                    stack.push(i);
                } else if (input[stack.peek()] == input[i]) {
                    /**DO NOTHING*/
                }
            }

        }

        int length = input.length;
        while(!stack.isEmpty()){
            int temp = stack.pop();
            int area = (length - temp)* input[temp];
            if(area>maxArea){
                maxArea = area;
            }
        }

        return maxArea;
    }

    public static int maxAreaRectangle(int[] input){
         Stack<Integer> posStack = new Stack<>();
         Stack<Integer> heightStack = new Stack<>();
         int maxArea=0;
         int area=0;
         int currentHeight;
         for(int i=0;i<input.length;i++){
             currentHeight = input[i];
             if(heightStack.isEmpty() || currentHeight > heightStack.peek()){
                 posStack.push(i);
                 heightStack.push(input[i]);
                 continue;
             }

             while(!heightStack.isEmpty() &&  heightStack.peek() > currentHeight){
                 area = (i- posStack.peek())*heightStack.pop();
                 if(area > maxArea){
                     maxArea = area;
                 }
             }

             if(!heightStack.isEmpty() && heightStack.peek() < currentHeight){

                 heightStack.push(currentHeight);
             }
         }
         return maxArea;
    }
}
