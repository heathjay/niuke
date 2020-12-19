/**
 * Definition for singly-linked list.
 * 
 */
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow=dummy;
        ListNode fast = head;
        while(fast != null && k!= 0){
            fast = fast.next;
            k--;
        }     
        if(k != 0){
            return dummy.next;
        }

        while(fast!= null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}