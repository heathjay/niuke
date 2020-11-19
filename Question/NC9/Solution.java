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
     * @return bool布尔型
     */
    
     public boolean hasPathSum (TreeNode root, int sum) {
        // write code here

        if(root == null) return false;

        if(root.left == null && root.right == null){
            return (sum - root.val == 0);
        }

        return hasPathSum(root.left, sum -root.val) || hasPathSum(root.right, sum - root.val);
    }


}