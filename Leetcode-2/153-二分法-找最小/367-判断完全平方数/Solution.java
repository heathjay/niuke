class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 2) return true;
        long left = 2;
        long right = num;
        while(right>=left){
            long mid = (right - left) /2 + left;
            if(mid * mid == num) return true;
            else if(mid * mid > num) right = mid -1;
            else left = mid+1;
        }
        return false;
    }
}