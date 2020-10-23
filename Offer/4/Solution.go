package Solution

type TreeNode struct {
	val   int
	left  *TreeNode
	right *TreeNode
}

func newTreeNode(val int) *TreeNode {
	return &TreeNode{
		right: nil,
		left:  nil,
		val:   val,
	}
}
func reConstructBinaryTree(pre []int, in []int) *TreeNode {
	if len(pre) == 0 || len(in) == 0 {
		return nil
	}
	root := newTreeNode(pre[0])
	for i := 0; i < len(in); i++ {
		if in[i] == pre[0] {
			root.left = reConstructBinaryTree(pre[1:i+1], in[0:i])
			root.right = reConstructBinaryTree(pre[i+1:], in[i+1:])
			break
		}
	}
	return root
}
