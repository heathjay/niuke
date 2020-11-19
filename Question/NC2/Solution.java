
  Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return ;

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        ListNode start = head;
        ListNode end = mid.next;

        mid.next = null;

        //反转end
        ListNode pre = end;
        ListNode cur = pre.next;
        while(cur!=null){
            if(pre == end){
                pre.next = null;
            }

            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }


        end = pre;

        //插入
        while(start != null && end != null){
            ListNode next1 = start.next;
            ListNode next2 = end.next;
            start.next = end;
            end.next = next1;
            start = next1;
            end = next2;
        }
        return;
    }
}