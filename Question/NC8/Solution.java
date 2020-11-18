import java.util.*;


  public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }
 

public class Solution {
    /**
     * 
     * @param root TreeNode类 
     * @param sum int整型 
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root, sum, 0, path,res);
        return res;
    }

    private void dfs(TreeNode root, int sum, int nowsum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res){
        path.add(root.val);
        if(root.right == null && root.left == null && sum == (nowsum + root.val)){
            res.add(new ArrayList<Integer>(path));
            return ;
        }

        if(root.left != null){
            dfs(root.left, sum, nowsum + root.val, path, res );
            path.remove(path.size()-1);
        }
        if(root.right != null){
            dfs(root.right, sum, nowsum + root.val, path, res);
            path.remove(path.size() - 1);
        }
        return;
    }
}