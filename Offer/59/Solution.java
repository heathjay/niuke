import java.util.ArrayList;


public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
import java.util.LinkedList;
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean flag = true;
        if(pRoot == null) return res;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(pRoot);
        while(!list.isEmpty()){
            int size = list.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = list.remove();
                if(flag){
                    tmp.add(node.val);
                }else{
                    tmp.add(0,node.val);
                }
                if(node.left != null) list.add(node.left);
                if(node.right != null) list.add(node.right);
            } 
            if(!tmp.isEmpty()) res.add(tmp);
            flag = !flag;
        }
        return res;
    }

}