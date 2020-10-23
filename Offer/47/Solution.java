public class Solution {
    int[] mask = {0x00000000, 0xFFFFFFFF};
    public int Sum_Solution(int n) {
        return positiveProduction(n+1,n) >> 1;
    }
    int positiveProduction(int m, int n){
        int result = 0;
        boolean isStop = (m != 0) && (result = (n & mask[m & 1]) + positiveProduction(m>>1, n<<1)) != 0;
        return result;
    }
}