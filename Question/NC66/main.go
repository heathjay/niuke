package main

//import . "nc_tools"

type ListNode struct {
	Val  int
	Next *ListNode
}

/**
 *
 * @param pHead1 ListNode类
 * @param pHead2 ListNode类
 * @return ListNode类
 */
func FindFirstCommonNode(pHead1 *ListNode, pHead2 *ListNode) *ListNode {
	// write code here
	p1 := pHead1
	p2 := pHead2
	if p1 == nil || p2 == nil {
		return nil
	}

	for {
		if p1 == p2 {
			break
		}

		p1 = p1.Next
		p2 = p2.Next
		if p1 != p2 {
			if p1 == nil {
				p1 = pHead2
			}
			if p2 == nil {
				p2 = pHead1
			}
		}
	}
	return p1
}
