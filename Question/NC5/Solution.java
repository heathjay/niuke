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
    int res = 0;
    int cur = 0;
    public int sumNumbers (TreeNode root) {
        // write code here
        if(root == null) return 0;
        cur = cur * 10 + root.val;
        if(root.left == null && root.right == null) sum += cur;
        else{
            sumNumbers(root.left);
            sumNumbers(root.right);
        }
        cur = cur / 10;
        return res;
    }
    int sum = 0;
    public void help(TreeNode root, int pre){
        if(root == null) return ;
        pre = pre * 10 + root.val;
        if(root.left == null && root.right == null){
            sum += pre;
        }else{
            help(root.left, pre);
            help(root.right, pre);
        }
    }
    public int sumNumbers1 (TreeNode root) {
        help(root, 0);
        return sum;
    }

}