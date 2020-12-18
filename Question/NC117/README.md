题目描述
已知两颗二叉树，将它们合并成一颗二叉树。合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。例如：
两颗二叉树是:
Tree 1  
     1   
    / \   
   3   2
  /      
 5   
    
Tree 2
   2
  / \
 1   3
  \   \
   4   7

合并后的树为
    3
   / \
  4   5
 / \    \
5  4    7
示例1
输入
复制

{1,3,2,5},{2,1,3,#,4,#,7}

返回值
复制

{3,4,5,5,4,#,7}

说明：本题目包含复杂数据结构TreeNode，点此查看相关信息