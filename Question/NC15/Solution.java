import java.util.*;


  public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }
 

public class Solution {
    /**
     * 
     * @param root TreeNode类 
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {

        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(list.size() != 0){
            int size = list.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = list.poll();
                tmp.add(node.val);
                if(node.left != null) list.add(node.left);
                if(node.right != null) list.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}