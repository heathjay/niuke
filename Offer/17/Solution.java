
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
            if( root1 == null || root2 == null){
                return false;
            }
            return doesTreeHasTree2(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean doesTreeHasTree2(TreeNode tree1, TreeNode tree2){
        if(tree2 == null) return true;
        if(tree1 == null) return false;
        
        if(tree1.val != tree2.val){
            return false;
        }
        return doesTreeHasTree2(tree1.left, tree2.left) && doesTreeHasTree2(tree1.right, tree2.right);
    }
}