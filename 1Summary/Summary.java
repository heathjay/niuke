class Summary{
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(num[i],i);
        }
        for(int i = 0; i < nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement)!=i){
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution.");
    }


    //一遍haspmap表格
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i, map.get(complement)};
            }
            map.put(num[i],i);
        }
        throw new IllegalArgumentException("No two sum solution.");
    }
}