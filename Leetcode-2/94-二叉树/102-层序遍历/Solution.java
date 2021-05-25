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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<ArrayList<Integer>>();
        List<TreeNode> stack = new LinkedList<>();

        if(root == null) return res;
        stack.add(root);
        while(!stack.isEmpty()){
            int size = stack.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                int node = stack.removeFirst();
                if(node != null) tmp.add(node.val);
                if(node.left != null) stack.add(node.left);
                if(node.right!= null) stack.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}