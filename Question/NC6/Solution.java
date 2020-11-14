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
     * @return int整型
     */
    public int res = Integer.MIN_VALUE;

    public int maxPathSum (TreeNode root) {
        // write code here
        getMax(root);
        return res;
    }

    public int getMax(TreeNode root){
        if(root == null) return 0;
        int leftMax = Math.max(0,getMax(root.left));
        int rightMax = Math.max(0,getMax(root.right));

        res = Math.max(res, Math.max(root.val + Math.max(leftMax, rightMax),root.val + leftMax + rightMax));
        return Math.max(leftMax,rightMax) + root.val;
    }
}