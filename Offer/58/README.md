题目描述
请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
说明：本题目包含复杂数据结构TreeNode，点此查看相关信息





根据上图可知：若满足对称二叉树，必须满足：
复制代码
1
2
3
	
1. L->val == R->val
2. L->left->val == R->right->val
3. L->right->val == R->left->val

因此可以自顶向下，递归求解即可。

    设置一个递归函数isSame(r1, r2),表示如果对称，返回true，否则返回false
    递归终止条件：r1==nullptr && r2==nulllptr, 直接返回true，否则，如果只有一个为nullptr，返回false
    下一步递归：如果r1->val == r2->val, 则isSame(root1->left, root2->right) && isSame(root1->right, root2->left); 