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
    public void flatten1(TreeNode root) {
        if(root == null) return ;
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        int size = list.size();
        for(int i = 1; i < size; i++){
            TreeNode pre = list.get(i-1), cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
        
    }

    public void preorder(TreeNode root, List<TreeNode> list){
        if(root!=null){
            list.add(root);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }
//寻找前驱
    public void flatten(TreeNode root) {

        TreeNode curr = root;

        while(curr != null){
            if(curr.left != null){
                TreeNode next = curr.left;
                TreeNode pre = next;
                while(pre.right != null){
                    pre = pre.right;
                }
                pre.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}