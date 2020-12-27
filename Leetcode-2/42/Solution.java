class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if(len == 0 || height == null) return 0;
        int res = 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        for(int i = 1; i < len ; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[len-1] = height[len-1];
        for(int i = len-2; i >= 0 ; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        for(int i = 1; i < len - 1; i++){
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }
}