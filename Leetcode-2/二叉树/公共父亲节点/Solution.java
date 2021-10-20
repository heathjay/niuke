import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class Solution {
    
    
    /**
     * 
     * @param root TreeNode类 
     * @param o1 int整型 
     * @param o2 int整型 
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        
        HashMap<Integer, Integer> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent.put(root.val, Integer.MAX_VALUE);
        queue.add(root);
        while(!parent.containsKey(o1) || !parent.containsKey(o2)){
            int len = queue.size();
            
            for(int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    parent.put(node.left.val, node.val);
                    queue.add(node.left);
                }
                if(node.right != null){
                    parent.put(node.right.val, node.val);
                        queue.add(node.right);                 
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        while(parent.containsKey(o1)){
            set.add(o1);
            o1 = parent.get(o1);
        }
        
        while(!set.contains(o2)){
            o2 = parent.get(o2);
        }
        return o2;
    }
}