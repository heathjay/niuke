package main

type ListNode struct {
	Val  int
	Next *ListNode
}

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param head ListNode类
 * @return ListNode类
 */
func oddEvenList(head *ListNode) *ListNode {
	// write code here
	if head == nil || head.Next == nil {
		return head
	}

	oddHead, evenHead := head, head.Next
	oddCur, evenCur := oddHead, evenHead

	for evenCur != nil && evenCur.Next != nil {
		oddCur.Next = evenCur.Next
		oddCur = oddCur.Next
		evenCur.Next = evenCur.Next
		evenCur = evenCur.Next
	}

	oddCur.Next = evenHead
	return oddHead
}

func main() {}
