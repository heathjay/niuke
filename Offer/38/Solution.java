import java.util.LinkedList;
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    public int TreeDepth(TreeNode root) {
        int res = 0;
        if ( root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                size--;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            res++;
        }
        return res;
    }
}

/**
    public int TreeDepth(TreeNode root) {
         if(root == null) return 0;
        return Math.max(TreeDepth(root.right),TreeDepth(root.left)) + 1;
    }
 */