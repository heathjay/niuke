import java.util.*;


  public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }
 

public class Solution {
    /**
     * 
     * @param t1 TreeNode类 
     * @param t2 TreeNode类 
     * @return TreeNode类
     */
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        if(t1 == null && t2 == null) return null;
        if(t1 == null && t2 != null) return t2;
        if(t1 != null && t2 == null) return t1;
        t1.val = t1.val + t2.val;
        if(t1.left != null && t2.left != null){
            mergeTrees(t1.left, t2.left);
        }else if(t1.left == null && t2.left != null){
            t1.left = t2.left;
        }
        if(t1.right != null && t2.right != null){
            mergeTrees(t1.right, t2.right);
        }else if(t1.right == null && t2.right!= null){
            t1.right = t2.right;
        }

        return t1;
    }
}