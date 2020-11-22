import java.util.*;


  public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }
 

public class Solution {
    /**
     * 
     * @param root TreeNode类 the root
     * @return int整型一维数组
     */
    TreeNode pre;
    /*
    public int[] findError (TreeNode root) {
  
        // write code here
        int[] res = new int[2];
        ArrayList<Integer> nums = new ArrayList<>();
        inorder(root,nums, res);
        return res;
    }
    
    public void inorder(TreeNode root, ArrayList<Integer> nums, int[] res){
        if(root == null) return;

        inorder(root.left, nums, res);
        if(!nums.isEmpty() && nums.get(nums.size()-1) > root.val && res[0] == 0 ){
            res[1] =  nums.get(nums.size()-1);
        }
        if(!nums.isEmpty() && nums.get(nums.size()-1) > root.val && res[1] != 0){
            res[0] = root.val;
        }
        nums.add(root.val);
        inorder(root.right, nums, res);
    }
    */

    public int[] findError (TreeNode root) {
  
        // write code here
        int[] res = new int[2];
        inorder(root,res);
        return res;
    }
    
    public void inorder(TreeNode root, int[] res){
        if(root == null) return;

        inorder(root.left, res);
        if(pre != null && pre.val > root.val && res[0] == 0 ){
            res[1] =  pre.val;
        }
        if(pre != null && pre.val > root.val && res[1] != 0){
            res[0] = root.val;
        }
        pre = root;
        inorder(root.right,  res);
    }

}