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
     * @param o1 int整型 
     * @param o2 int整型 
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        return CommonAncestor(root, o1, o2);
    }

    public TreeNode CommonAncestor(TreeNode root, int o1, int o2){
        if(root == null || root.val == o1 || root.val == o2){
            return root;
        }
        TreeNode left = CommonAncestor(root.left, o1, o2);
        TreeNode right = CommonAncestor(root.right, o1,o2);

        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }

        return root;
    }
}