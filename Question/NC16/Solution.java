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
     * @return bool布尔型
     */
    public boolean isSymmetric (TreeNode root) {
        // write code here
        if(root == null) return true;
        return help(root.left, root.right);
    }

    public boolean help(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return left.val == right.val && help(left.left, right.right) && help(left.right, right.left);
    }
}