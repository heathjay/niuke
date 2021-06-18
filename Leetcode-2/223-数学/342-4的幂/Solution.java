class Solution {
    public boolean isPowerOfFour(int n) {
        // if(n <= 0) return false;
        // while(n % 4 == 0){
        //     n = n / 4;
        // }
        // return n == 1;


        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;

    }


}