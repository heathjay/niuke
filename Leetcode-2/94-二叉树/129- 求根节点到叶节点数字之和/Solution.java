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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return sum;
        dfs(root, 0);
        return sum;
    }
    public void dfs(TreeNode root, int pre){
        if(root.left == null && root.right == null){
            sum += pre * 10 + root.val;
            return;
        }

        int cur = root.val + pre * 10;
        if(root.left != null){
            dfs(root.left, cur);
        }
        if(root.right != null){
            dfs(root.right, cur);
        }

        return;
    }
}