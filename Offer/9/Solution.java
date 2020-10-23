public class Solution {
    public int JumpFloorII(int target) {
        if(target == 0 || target == 1) return 1;
        int res = 1;
        for(int i = 2; i <= target ; i++){
            res = res << 1;
        }
        return res;
    }
}