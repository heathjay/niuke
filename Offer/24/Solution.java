import java.util.ArrayList;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    private ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return res;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null) res.add(new ArrayList<Integer>(list));
        ArrayList<ArrayList<Integer>> result1 = FindPath(root.left, target);
        ArrayList<ArrayList<Integer>>  result2 = FindPath(root.right, target);
        list.remove(list.size()-1);
        return res;
    }
}