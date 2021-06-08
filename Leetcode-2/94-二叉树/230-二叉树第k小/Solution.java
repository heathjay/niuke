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
    public int kthSmallest1(TreeNode root, int k) {
        List<TreeNode> tmp = new ArrayList<TreeNode>();
        inorder(root, tmp);
        return tmp.get(k-1).val;
    }
    public void inorder(TreeNode root, List<TreeNode> tmp){
        if(root == null) return;
        inorder(root.left, tmp);
        tmp.add(root);
        inorder(root.right, tmp);
    }

    public int kthSmallest(TreeNode root, int k){
        LinkedList<TreeNode> stack = new LinkedList<>();

        while(true){
            while(root != null){
                stack.add(root);
                root = root.left;
            }

            root = stack.removeLast();
            if(--k == 0) return root.val ;
            root = root.right;
        }
    }
}