public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        int count = 0;
        for(int i = 0 ; i < 32 && n != 0; i++){
            if((n&1) == 1) count++;
            n = n >> 1;
        }
        return count;
    }

    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

}