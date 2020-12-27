class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, target, candidates, new ArrayList<Integer> ());
        return res;
    }
    public void dfs(int start, int target, int[] candidates, ArrayList<Integer> tmp){
        if(target == 0){
            res.add(new ArrayList<Integer> (tmp));
            return;
        }
        if(start == candidates.length){
            return;
        }
        for(int i = start;i<candidates.length;i++){
            if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
            }
            if(target-candidates[i] >= 0){
                tmp.add(candidates[i]);
                dfs(i+1, target-candidates[i], candidates, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}