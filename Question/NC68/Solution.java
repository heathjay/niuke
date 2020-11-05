public class Solution {
    public int JumpFloor(int target) {
        if(target <= 2){
            return target;
        }

        int pre = 1, sum =2;
        for(int i = 3; i <= target; i++){
            sum = pre + sum;
            pre = sum - pre;
        }
        return sum;
    }
}