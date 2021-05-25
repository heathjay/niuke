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
    private HashMap<Integer, Integer> map  = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n= preorder.length ;
        for(int i = 0 ; i < n ; i++){
            map.put(inorder[i], i);
        }

        return myorder(preorder, inorder,0, n-1, 0, n-1);
    }

    public TreeNode myorder(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend){
        if(prestart> preend) return null;

        int preorder_root = prestart;
        int inorder_root = map.get(preorder[preorder_root]);

        TreeNode root = new TreeNode(preorder[preorder_root]);
        int left_size = inorder_root - instart;
        root.left = myorder(preorder, inorder, prestart + 1, prestart + left_size, instart, inorder_root-1);
        root.right = myorder(preorder, inorder, prestart+left_size +1, preend, inorder_root+1, inend);
        return root;
    }
}