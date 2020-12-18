class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int x1 = x;
        int sum = 0;
        int bound = Integer.MAX_VALUE;
        while(x1 > 0){
            int c = x1 % 10;
            if(sum > bound || (sum == bound && c >= 8)){
                return false;
            }
            sum = sum * 10 + c;
            x1 = x1 / 10;
        }
        return sum == x ;
    }
    public boolean isPalindrome1(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}