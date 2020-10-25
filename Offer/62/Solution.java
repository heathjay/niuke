
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
import java.util.Stack;
public class Solution {
    
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot == null || k <= 0){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRoot;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(--k == 0){
                    return cur;
                }
                cur = cur.right;
            }
        }
        return null;
    }


}