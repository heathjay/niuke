
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    int index = -1;
    String Serialize(TreeNode root) {
        if(root == null){
            return "#";
        }else{
            return root.val + "," + Serialize(root.left) + "," + Serialize(root.right);
        }
    }
    TreeNode Deserialize(String str) {
        String[] s = str.split(",");
        index++;
        int len = s.length;
        if(index > len){
            return null;
        }
        TreeNode node = null;
        if(!s[index].equals("#")){
            node = new TreeNode(Integer.parseInt(s[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}