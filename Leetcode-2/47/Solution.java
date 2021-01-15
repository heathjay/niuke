import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(res, new ArrayList<Integer>(), 0, visited, nums);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> tmp, int index, boolean[] visited, int[] nums){
        if(index == nums.length){
            res.add(new ArrayList(tmp));
            return;
        }

        for(int i = 0 ; i < nums.length; i++){
            if(visited[i] || (i >0 && nums[i] == nums[i-1] && !visited[i-1])){
                continue;
            }
            tmp.add(nums[i]);
            visited[i] = true;
            dfs(res, tmp, index+1, visited, nums);
            tmp.remove(tmp.size()-1);
            visited[i] = false;

        }
    }
}