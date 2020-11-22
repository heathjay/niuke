
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
public class Solution {
    public int nodeNum(TreeNode head) {
        return head == null? 0:(nodeNum(head.left) + nodeNum(head.right));
    }
}