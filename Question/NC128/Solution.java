import java.util.*;


public class Solution {
    /**
     * max water
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    /*
    //超时
    public long maxWater (int[] arr) {
        // write code here
        //暴力法
        int res = 0;
        int length = arr.length;
        for(int i = 1;i < length; i++){
            int max_left = 0, max_right=0;
            for(int j = i; j >= 0 ; j--){
                max_left = Math.max(max_left, arr[j]);
            }
            for(int j = i ; j < length ; j++){
                max_right = Math.max(max_right, arr[j]);
            }

            res += Math.min(max_left, max_right) - arr[i];
        }
        return res;
    }
    */
//动态编程
/*
    public long maxWater (int[] arr) {
        int length = arr.length;
        if(length == 0 || arr == null) return 0;
        int res = 0;
        int[] max_left = new int[length];
        int[] max_right = new int[length];

        max_left[0] = arr[0];
        for(int i = 1; i < length; i ++){
            max_left[i] = Math.max(arr[i], max_left[i-1]);
        }

        max_right[length-1] = arr[length-1];
        for(int i = length -2; i >= 0; i--){
            max_right[i] = Math.max(arr[i],max_right[i+1]);
        }

        for(int i = 1; i < length; i++){
            res += Math.min(max_left[i], max_right[i]) - arr[i];
        }
        return res;
    }
    */

    public long maxWater (int[] arr) {
        int res = 0, current = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while(current < height.length){
            while(!stack.isEmpty() && height[current] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int distance = current - stack.peek() - 1;
                int bounded_height= Math.min(height[current], height[stack.peek()]) - height[top];
                res += distance * bounded_height;
            }

            return res;
        }
    }
}