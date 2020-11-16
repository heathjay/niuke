import java.util.*;


  public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }
 

public class Solution {
    /**
     * 
     * @param root TreeNode类 the root
     * @return bool布尔型一维数组
     */
    
    public boolean isValidBST_trace(TreeNode root, long lower, long upper){
        if(root == null) return true;
        if(root.val <= lower || root.val >= upper){
            return false;
        }

        return isValidBST_trace(root.left, lower, root.val) && isValidBST_trace(root.right, root.val, upper);
    }
    public boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.peek()!= null){
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }

        while(!queue.isEmpty() && queue.peek() == null){
            queue.poll();
        }

        return queue.isEmpty();
    }
    public boolean[] judgeIt (TreeNode root) {
        // write code here
        boolean[] res = new boolean[2];
        res[0] = isValidBST_trace(root,Long.MIN_VALUE, Long.MAX_VALUE);
        res[1] = isCompleteTree(root);
        return res;
    }
}