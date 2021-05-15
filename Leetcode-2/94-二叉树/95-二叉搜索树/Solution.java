/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return generateTrees(1,n);
    }


    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> allTrees = new ArrayList<TreeNode>();
        if(start > end){
            allTrees.add(null);
            return allTrees;
        }

        for(int i = start; i <= end;i++) {
            List<TreeNode> leftTrees = generateTrees(start, i -1);
            List<TreeNode> rightTrees = generateTrees(i+1, end);


            for(TreeNode left : leftTrees){
                for(TreeNode right : rightTrees){
                    
                }
            }
        }
    }
}