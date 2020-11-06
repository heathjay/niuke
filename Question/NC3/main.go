package main

//import . "nc_tools"

type ListNode struct {
	Val  int
	Next *ListNode
}

/**
 *
 * @param head ListNode类
 * @return ListNode类
 */
func detectCycle(head *ListNode) *ListNode {
	// write code here
	slow := head
	fast := head
	if fast == nil {
		return head
	}

	for {
		if fast == nil || fast.Next == nil {
			break
		}

		fast = fast.Next.Next
		slow = slow.Next
		if slow == fast {
			fast = head
			for {
				slow = slow.Next
				fast = fast.Next
				if slow == fast {
					return slow
				}
			}
		}
	}
	return nil
}
func main() {}
