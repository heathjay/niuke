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
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        dfs(root, new StringBuilder());
        return res;
    }
    private void dfs(TreeNode root, StringBuilder cur) {
       if(root == null){
           return;
       }

       if(root.left == null && root.right == null){
           res.add(cur.toString()+root.val);
           return;
       }

       int size = cur.length();
       cur.append(root.val).append("->");
       dfs(root.left, cur);
       dfs(root.right, cur);
       cur.delete(size, cur.length());
    }

}