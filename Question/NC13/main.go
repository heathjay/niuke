package main

//import . "nc_tools"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
 *
 * @param root TreeNode类
 * @return int整型
 */
func maxDepth(root *TreeNode) int {
	// write code here
	if root == nil {
		return 0
	}

	leftDep := maxDepth(root.Left)
	rightDep := maxDepth(root.Right)
	max := 0
	if leftDep > rightDep {
		max = leftDep
	} else {
		max = rightDep
	}
	return max + 1
}

func main() {}
