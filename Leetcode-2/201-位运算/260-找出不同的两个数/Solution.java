class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for(int n : nums){
            res ^= n;
        }

        int div = 1;
        while((div & res) == 0 ){
            div <<= 1;
        }
        int a =0 , b = 0;
        for(int n : nums){
            if((div & n) != 0){
                a ^= n;
            }else{
                b ^= n;
            }
        }
        return new int[]{a,b};
    }
}