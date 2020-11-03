import java.util.*;


  public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }
 

public class Solution {
    /**
     * 
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    private static ArrayList<Integer> first = new ArrayList<>();
    private static ArrayList<Integer> middle = new ArrayList<>();
    private static ArrayList<Integer> last = new ArrayList<>();

    public int[][] threeOrders (TreeNode root) {
        // write code here
        int[][] orders = new int[3][];
        firstOrder(root);
        orders[0] = first.stream().mapToInt(Integer::intValue).toArray();
        middleOrder(root);
        orders[1] = middle.stream().mapToInt(Integer::intValue).toArray();
        lastOrder(root);
        orders[2] = last.stream().mapToInt(Integer::intValue).toArray();
        return orders;
    }
    private static void firstOrder(TreeNode root){
        if(root != null){
            first.add(root.val);
            firstOrder(root.left);
            firstOrder(root.right);
        }
    }
    private static void lastOrder(TreeNode root){
        if(root != null){
            lastOrder(root.left);
            lastOrder(root.right);
            last.add(root.val);
        }
    }
    private static void middleOrder(TreeNode root){
        if(root != null){
            middleOrder(root.left);
            middle.add(root.val);
            middleOrder(root.right);
        }
    }


}