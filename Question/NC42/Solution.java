import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class Solution {

    boolean[] vis;

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        vis = new boolean[num.length];
        if(num.length == 0) return res;
        ArrayList(num);
        backtrack(nums, res, 0, tmp);
    }


   private void backtrack(int[] nums, ArrayList<ArrayList<Integer>> res, int idx, ArrayList<Integer> tmp){
       if(idx == nums.length){
           res.add(new ArrayList<Integer>(tmp));
           return ;
       }

       for(int i = 0 ; i < nums.length; i++){
           if(vis[i] || (i > 0 && nums[i] == nums[i-1] && !vis[i-1])){
               continue;
           }

           tmp.add(nums[i]);
           vis[i] = true;
           backtrack(nums, res, idx + 1, tmp);
           vis[i] = false;
           tmp.remove(idx);
       }
   }
}