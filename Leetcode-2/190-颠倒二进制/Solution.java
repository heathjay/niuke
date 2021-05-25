public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0;
        for(int i = 0; i < 32 && n != 0; i++){
            rev  |= (n & 1)<< (31 -i);
            n = n >>1;
        }  
        return rev; 
    }
}