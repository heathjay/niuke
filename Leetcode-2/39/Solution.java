import java.util.List;
import java.util.ArrayList;
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, target, candidates, new ArrayList<Integer>());
        return res;
    }

    public void dfs(int index, int target,int[] candidates, ArrayList<Integer> tmp){
        if(target == 0){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        if(index == candidates.length){
            return;
        }
        dfs(index+1, target, candidates, tmp);
        if(target - candidates[index] >= 0){
            tmp.add(candidates[index]);
            dfs(index,target-candidates[index], candidates,tmp);
            tmp.remove(tmp.size()-1);
        }
        return ;
    }
}