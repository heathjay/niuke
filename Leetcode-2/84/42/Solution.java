class Solution {
    //两个数组左右扫描
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        if(len == 0 || height == null) return 0;
        left[0]=height[0];
        right[len-1]= height[len-1];
        for(int i = 1; i < len; i++){
            left[i] = Math.max(left[i-1],height[i]);
        }
        for(int i = len-2; i >=0 ; i--){
            right[i] = Math.max(right[i+1],height[i]);
        }

        int res = 0;
        for(int i = 0; i < len;i++){
            int h = Math.min(left[i], right[i]);
            res += h - height[i];
        }
        return res;
    }
    

    //单调栈
    public int trap1(int[] height){
        Stack<Integer> stack = new Stack<>();

        int water = 0;
        if(height.length < 3){
            return water;
        }

        for(int i = 0 ; i < height.length; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                //
                int popnum = stack.pop();
                while(!stack.isEmpty() && height[popnum] == height[stack.peek()]){
                    stack.pop();
                }

                if(!stack.isEmpty()){
                    int temp = height[stack.peek()];
                    int hight = Math.min(stack.peek(), temp) - height[popnum];
                    int width = i - stack.peek() -1;
                    water += hight * width;
                }
            }
            stack.push(i);
        }
        return water;
    }

}