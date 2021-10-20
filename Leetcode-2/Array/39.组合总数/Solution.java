class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<int[]> freq = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if(len == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, new ArrayList<Integer>(), target, 0);
        return res;
    }

    public void dfs(int[] candidates, ArrayList<Integer> path, int target, int indx){
        int len = candidates.length;
        if(indx == len){
            
            return;
        }
        if(target == 0){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        //直接跳过
        dfs(candidates, path, target, indx+1);
        if(target - candidates[indx] >= 0){
            path.add(candidates[indx]);
            //使用该位
            dfs(candidates, path, target-candidates[indx], indx);
            path.remove(path.size()-1);
        }
    }
}