class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        backtrace(0, nums, path);
        return res;
    }
    public void backtrace(int index, int[] nums,List<Integer> path){
        res.add(new ArrayList<>(path));
        if(path.size() == nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++){
            path.add(nums[i]);
            backtrace(i+1, nums, path);
            path.remove(path.size()-1);
        }
    }
}