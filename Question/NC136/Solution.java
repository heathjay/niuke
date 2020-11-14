import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     * @param xianxu int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve (int[] xianxu, int[] zhongxu) {
        TreeNode root = reBuild(xianxu, zhongxu);
        return bfs(root);
    }
    public TreeNode reBuild(int[] preOrder, int[] inOrder){
        if(preOrder == null || preOrder.length == 0) return null;
        int val = preOrder[0], pos = 0, len =preOrder.length;
        TreeNode root = new TreeNode(val);

        for(; pos < len; pos++){
            if(inOrder[pos] == val)break;
        }

        root.left = reBuild(Arrays.copyOfRange(preOrder, 1, pos + 1),
             Arrays.copyOfRange(inOrder, 0, pos));
     root.right = reBuild(Arrays.copyOfRange(preOrder, pos + 1, len),
             Arrays.copyOfRange(inOrder, pos + 1, len));
 
     return root;
    }
    public int[] bfs(TreeNode root){
 
        if (root == null) return null;
    
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
    
        for (TreeNode tmp = root; !queue.isEmpty(); ){
            // 此处注意循环中 queue.size() 在变，应事先记录 size--
            for (int size = queue.size(); size > 0; size--){
                tmp = queue.poll();
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
            // 添加每层最右元素
            list.add(tmp.val);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}