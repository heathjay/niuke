import java.util.ArrayList;
import java.util.Queue;
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
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
       
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);
        while(!temp.isEmpty()){
            int n = temp.size();
            for(int i = 0; i < n; i++){
                TreeNode node = temp.poll();
                res.add(node.val);
                if(node.left != null) temp.add(node.left);
                if(node.right != null) temp.add(node.right);
            }
        }
        return res;
    }
}