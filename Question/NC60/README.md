题目描述
给定一棵二叉树，已经其中没有重复值的节点，请判断该二叉树是否为搜索二叉树和完全二叉树。
示例1
输入
复制

{2,1,3}

返回值
复制

[true,true]

备注:

n≤500000n \leq 500000n≤500000

说明：本题目包含复杂数据结构TreeNode，点此查看相关信息

     2).剩余队列判空法

     突然发现使用上述标记法要考虑的情况很多，不太方便，于是又提出了另一种方法，就是剩余队列判空法

     这个方法同样的用到了队列这种辅助结构，那仫如何只通过队列这个结构来判断一棵树是否是完全二叉树呢？试想一下，如果我们把一棵树的所有结点，包括叶子结点的左右空孩子都通过层序遍历入队列会发生什仫情况？详细的分析见下图：


验证二叉搜索树

    算法
        1.递归
        2.重载一个函数，界定节点值的范围(lower, upper)
        3.递归判断左子树和右子树是否是二叉搜索树 


	
public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
}
 
private boolean isValidBST(TreeNode root, long lower, long upper) {
    if (root == null) {
        return true;
    }
    if (root.val <= lower || root.val >= upper) {
        return false;
    }
    return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
}

    算法
        1.中序遍历二叉树
            中序遍历递归和迭代算法 
        2.判断结果是否是升序 


	
public boolean isValidBST(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<>(10);
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while (!stack.isEmpty() || curr != null) {
        if (curr != null) {
            stack.push(curr);
            curr = curr.left;
        } else {
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
    }
    for (int i = 1; i < list.size(); i++) {
        if (list.get(i) <= list.get(i-1)) {
            return false;
        }
    }
    return true;
}



    算法
        1.层次遍历直至遇到第一个空节点
        2.完全二叉树在遇到空节点之后剩余的应当全是空节点 


	
public boolean isCompleteTree(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while (queue.peek() != null) {
        TreeNode node = queue.poll();
        queue.offer(node.left);
        queue.offer(node.right);
    }
 
    while (!queue.isEmpty() && queue.peek() == null) {
        queue.poll();
    }
    return queue.isEmpty();
}
