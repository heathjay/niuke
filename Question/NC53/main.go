package main

//import . "nc_tools"

type ListNode struct {
	Val  int
	Next *ListNode
}

/**
 *
 * @param head ListNode类
 * @param n int整型
 * @return ListNode类
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	// write code here
	fast := head
	slow := head
	if head == nil {
		return head
	}

	var pre *ListNode
	for {
		if fast == nil {
			return nil
		} else {
			fast = fast.Next

		}
		n--
		if n == 0 {
			break
		}
	}

	if fast == nil {
		return head.Next
	}

	for {

		fast = fast.Next
		pre = slow
		slow = slow.Next
		if fast == nil {
			pre.Next = slow.Next
			break
		}
	}
	return head

	return head
}
func main() {}
