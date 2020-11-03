package main

#import . "nc_tools"

type ListNode struct {
	Val  int
	Next *ListNode
}

/**
 *
 * @param head ListNode类
 * @return bool布尔型
 */
func hasCycle(head *ListNode) bool {
	// write code here
	slow := head
	fast := head
	for{
		if fast == nil || fast.next == nil{
			break
		}
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast{
			return true
		}
	}
	return false
}
