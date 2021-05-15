class Solution {
    public int climbStairs(int n) {
        int sum = 1, one = 1;
        if(n == 1 ) return sum;
        for(int i = 1; i < n;i++){
            sum += one;
            one = sum - one;
        }
        return sum;
    }
}