import java.util.*;


  public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }
 

public class Solution {
    /**
     * 
     * @param root1 TreeNode类 
     * @param root2 TreeNode类 
     * @return bool布尔型
     */
    public boolean isContains (TreeNode root1, TreeNode root2) {
        // write code here
        if(root1 == null && root2 == null){
            return true;
        }

        if((root1 == null && root2 != null )|| (root1 != null && root2 == null))return false;

        if(root1.val == root2.val){
            return isContains(root1.left,root2.left) && isContains(root1.right, root2.right);
        }else{
            return isContains(root1.left,root2) || isContains(root1.right,root2);
        }
    }
}