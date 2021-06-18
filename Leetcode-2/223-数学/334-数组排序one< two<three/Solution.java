class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for(int three : nums){
            if(three < two) return true;
            else if(three <= one) one = three;
            else two = three;
            //if(three > one && three < two) two = three;
        }
        return false;
    }
}
//核心想法：遍历一遍数组，希望遍历到的这个数three，前面已经有一个比他小的数two，再前面有一个比two小的数one
//我们需要维护两个变量：one和two。代表递增子序列的第一个数和第二个数。