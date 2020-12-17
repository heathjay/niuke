class Solution {
    public int reverse(int x) {
        int flag = x > 0 ? 1 : -1;
        if( x  <= Integer.MIN_VALUE) return 0;
        x = x > 0 ? x : (-1) * x;
        int sum =0;
        int bound = Integer.MAX_VALUE/10;
        while(x != 0){
            int left = x % 10 ;
            if(sum > bound  || (sum == bound && ((flag == 1 && left >= 8)||(flag == -1 && left >=9)))){
                return 0;
            }
            sum = sum * 10 + left;
            x = x / 10;
        }   
        return sum*flag;
    }
}