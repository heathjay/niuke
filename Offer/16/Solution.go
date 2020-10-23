package Solution

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
func Merge(pHead1 *ListNode, pHead2 *ListNode) *ListNode {
	if pHead1 == nil {
		return pHead2
	}
	if pHead2 == nil {
		return pHead1
	}
	dummy := &ListNode{
		0,
		nil,
	}
	curr := dummy
	for {
		if pHead1 == nil || pHead2 == nil {
			break
		}
		if pHead1.Val > pHead2.Val {
			curr.Next = pHead2
			pHead2 = pHead2.Next
		} else {
			curr.Next = pHead1
			pHead1 = pHead1.Next
		}
		curr = curr.Next
	}
	if pHead1 != nil {
		curr.Next = pHead1
	}
	if pHead2 != nil {
		curr.Next = pHead2
	}
	return dummy.Next
}
