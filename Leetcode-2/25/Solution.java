/**
 * Definition for singly-linked list.
 */
 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(head != null){
            ListNode tail = pre;
            for(int i = 0 ; i < k; ++i){
                tail = tail.next;
                if(tail == null){
                    return dummy.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse1 = reverse(head,tail);
            head = reverse1[0];
            tail = reverse1[1];

            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
    }
    public ListNode[] reverse(ListNode head, ListNode tail){
        ListNode pre = tail.next;
        ListNode p = head;
        while(pre != tail){
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return new ListNode[]{tail,head};
    }
}
