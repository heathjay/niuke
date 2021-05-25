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
    int postIndex;
    int[] postorder;
    int[] inorder;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        postIndex = postorder.length - 1;
        for(int i = 0; i < postIndex; i++){
            map.put(postorder[i], i);
        }
        return help(0, inorder.length - 1);
    }

    public TreeNode help(int in_left, int in_right){
        if(in_left > in_right){
            return null;
        }

        int root_val = postorder[postIndex];
        TreeNode root = new TreeNode(root_val);
        int index = map.get(root_val);
        postIndex--;
        root.right = help(index+1, in_right);
        root.left = help(in_left, index-1);
        return root;
    }
}