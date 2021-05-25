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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.add(root);
        boolean flag = false;

        while(!stack.isEmpty()){
            int size = stack.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = stack.removeFirst();
                if(!flag) tmp.add(node.val);
                else tmp.addFirst(node.val);
                if(node.left != null) stack.add(node.left);
                if(node.right != null) stack.add(node.right);
            }
            res.add(tmp);
            flag = !flag;
        }
        return res;
    }
}