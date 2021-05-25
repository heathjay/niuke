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
    

    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root,nums);
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    public void inorder(TreeNode root, List<Integer> nums){
        if(root == null) return ;
         inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    public int[] findTwoSwapped(List<Integer> nums){
        int len = nums.size();
        int x = -1, y = -1;
        for(int i=0; i<len-1; i++){
           
            if(nums.get(i+1) < nums.get(i)){
                y = nums.get(i + 1);
                if(x==-1){
                    x = nums.get(i);
                }else{
                    break;
                }
            }
        }
        return new int[]{x,y};
    }

    public void recover(TreeNode root, int count, int x, int y){
        if(root != null){
            if(root.val == x || root.val == y){
                root.val = (root.val == x ? y : x);
                count --;
                if(count == 0) return;
            }
            recover(root.left, count, x, y);
            recover(root.right, count, x,y);
        }
    }



    public void recoverTree1(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode x = null, y = null, pred = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = root;
            root = root.right;
        }

        swap(x, y);
    }

    public void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
    
}