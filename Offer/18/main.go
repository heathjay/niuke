package main

import . "nc_tools"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
 *
 * @param pRoot TreeNode类
 * @return TreeNode类
 */
func Mirror(pRoot *TreeNode) *TreeNode {
	// write code here
	if pRoot == nil {
		return
	}
	Mirror(pRoot.left)
	Mirror(pRoot.right)
	temp := pRoot.left
	pRoot.left = pRoot.right
	pRoot.right = temp
}
