import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        if(len == 0 || heights == null) return 0;
        int maxArea = 0;
        for(int i = 0; i < len; i++){
            int left = i, right=i;
            int cur = heights[i];
            while(left > 0 && heights[left-1] >= cur){
                left--;
            }

            while(right < len - 1 && heights[right+1] >= cur){
                right++;
            }

            int width = right - left + 1;
            maxArea = Math.max(width*cur, maxArea);
        }
        return maxArea;
    }


    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 0){
            return 0;
        }

        if(len == 1){
            return heights[0];
        }
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peekLast()]){
                int curHeight = heights[stack.pollLast()];
                while(!stack.isEmpty() && heights[stack.peekLast()] == curHeight){
                    stack.pollLast();
                }
                int curWidth;
                if(stack.isEmpty()){
                    curWidth = i;
                }else{
                    curWidth = i - stack.peekLast() -1;
                }
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }


        while(!stack.isEmpty()){
            int curHeight = heights[stack.pollLast()];
            while(!stack.isEmpty() && heights[stack.peekLast()] == curHeight){
                stack.pollLast();
            }

            int curWidth;
            if(stack.isEmpty()){
                curWidth = len;
            }else{
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }
}