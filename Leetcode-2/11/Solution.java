class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        if(len <= 0) return 0;
        int left = 0, right = len - 1;
        int max = 0;
        while(left<right){
            max = Math.max(Math.min(height[left],height[right]) * ( right - left),max);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}