class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(res, new ArrayList<Integer>(), 0, nums, visited);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> tmp, int index, int[] nums, boolean[] visited){
        if(nums.length == index){
            res.add(new ArrayList(tmp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                tmp.add(nums[i]);
                visited[i] = true;
                dfs(res, tmp, index+1, nums, visited);
                tmp.remove(tmp.size()-1);
                visited[i] = false;
            }

        }
    }
}