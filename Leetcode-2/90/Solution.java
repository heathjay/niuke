class Solution {
	List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for(int k = 0 ; k < nums.length; k++){
            backtrace(nums, new ArrayList<Integer>(), k, 0);
        }
        return res;
    }

    public void backtrace(int[] nums, ArrayList<Integer> cur, int k, int start){
        if(cur.size() == k){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i]== nums[i-1]){
                continue;
            }
            cur.add(nums[i]);
            backtrace(nums, cur, k,i+1);
            cur.remove(cur.size()-1);
        }
    }
}