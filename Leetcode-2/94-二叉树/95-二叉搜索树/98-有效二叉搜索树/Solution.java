/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * 递归
     */
    public boolean isValidBST1(TreeNode root) {
        return help(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean help(TreeNode root, long lower, long upper){
        if(root == null){
            return true;
        }

        if(root.val <= lower || root.val >= upper){
            return false;
        }

        return help(node.left, lower, root.val) && help(node.right, root.val, upper);
    }
    /**
     * 中序遍历
     */
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        //判断左子树
        if(!isValidBST(root.left)) return false;
        if(pre >= root.val) return false;
        pre = root.val;

        //判断右子树
        if(!isValidBST(root.right)) return false;
        return true;
    }
}