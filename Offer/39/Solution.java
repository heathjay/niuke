public class Solution {
    public int depth(TreeNode root){
        if(root == null) return 0;
        //左右子树高度差不超过1
        int left = depth(root.left);
        if(left == -1) return -1;
        int right = depth(root.right);
        if(right == -1)return -1;
        if(left - right < (-1) || left - right > 1)
            return -1;
        else
            return 1 + (left > right ? left : right);
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }
}