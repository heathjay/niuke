
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    TreeNode pre = null;
    TreeNode root = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        Convert(pRootOfTree);
        if(root == null){
            root = pRootOfTree;
        }
        if( pre != null){
            pRootOfTree.left = pre;
            pre.right = pRootOfTree;
        }

        pre = pRootOfTree;
        Convert(pRootOfTree.right);
        return root;

    }


}