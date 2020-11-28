import java.util.*;


  public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }
 

public class Solution {
    /**
     * 
     * @param num int整型一维数组 
     * @return TreeNode类
     */
    public TreeNode sortedArrayToBST (int[] num) {
        // write code here
        if(num == null) return null;
        return helper(num, 0, num.length - 1);
    }

    public TreeNode helper(int[] num, int left, int right){
        if(left > right) return null;
        int mid = left + (right - left + 1) >> 1;
        TreeNode lnode = helper(num, left, mid - 1);
        TreeNode rnode = helper(num, mid+1, right);
        TreeNode root = new TreeNode(num[mid]);
        if(lnode != null) root.left = lnode;
        if(rnode != null) root.right = rnode;
        return root;
    }
}