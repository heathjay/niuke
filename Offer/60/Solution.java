import java.util.ArrayList;
import java.util.LinkedList;


public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
/*
public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null) return res;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(pRoot);
        while(!list.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<>();
            int size = list.size();
            for(int i = 0 ; i < size; i++){
                TreeNode node = list.remove(0);
                tmp.add(node.val);
                if(node.left!=null) list.add(node.left);
                if(node.right != null) list.add(node.right);
            }
            if(!tmp.isEmpty()) res.add(tmp);
        }
        return res;
    }
    
}
*/
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        dfs(pRoot, 0 , res);
        return res;
    }
    private void dfs(TreeNode pRoot, int deep, ArrayList<ArrayList<Integer>> res){
        if(pRoot == null){
            return;
        }
        if(deep >= res.size()){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(pRoot.val);
            res.add(list);
        }else{
            ArrayList<Integer> list = res.get(deep);
            list.add(pRoot.val);
        }
        dfs(pRoot.left, deep + 1, res);
        dfs(pRoot.right, deep + 1 , res);
    }
}
