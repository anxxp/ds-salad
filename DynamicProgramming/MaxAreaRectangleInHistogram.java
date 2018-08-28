package DynamicProgramming;

import java.util.Stack;

 /**
 * Given an array representing height of bar in bar graph, find max histogram
 * area in the bar graph. Max histogram will be max rectangular area in the
 * graph.
 */
public class MaxAreaRectangleInHistogram {

     public static void main(String args[]){
         int input[] = {1,3,5,3,2,2,3,3,1,0,3,6};
         int maxArea = maxHistogram(input);
         System.out.println(maxArea);
     }

    public static  int maxHistogram(int input[]){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int area ;

        stack.push(0);
        int i=1;

        while(!stack.isEmpty()){

            if(input[stack.peek()] <= input[i]){
                stack.push(i);
                if(i<=input.length){
                    i++;
                }
            }else{
                int top = stack.pop();
                /**
                 * if stack is empty means everything till i has to be
                 * greater or equal to input[top] so get area by
                 * input[top] * i;
                 * */
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                /**
                 * if stack is not empty then everything from i-1 to input.peek() + 1
                 * has to be greater or equal to input[top]
                 * so area = input[top]*(i - stack.peek() - 1);
                 * */
                else{
                    area = input[top] * (i - stack.peek() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
