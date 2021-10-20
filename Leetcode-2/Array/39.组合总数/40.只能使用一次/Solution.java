class Solution {
    // List<int[]> freq = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        // for(int num : candidates){
        //     int size = freq.size();
        //     if(freq.isEmpty() || num != freq.get(size-1)[0]){
        //         freq.add(new int[]{num, 1});
        //     }else{
        //         ++freq.get(size-1)[1];
        //     }
        // }
        dfs(0, target, candidates);
        return res;
    }

    public void dfs(int begin, int target, int[] candidates){
        if(target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for(int i = begin; i < candidates.length; i++){
            if(target - candidates[i] < 0){
                break;
            }

            if(i > begin && candidates[i] == candidates[i-1])continue;

            path.add(candidates[i]);
            dfs(i+1, target-candidates[i], candidates);
            path.remove(path.size()-1);
        }

    }
}