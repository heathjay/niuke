/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1);
        ListNode l = left;
        ListNode right = new ListNode(-1);
        ListNode r = right;
        if(head == null) return null;
        while(head != null){
            if(head.val < x){
                l.next = head;
                l=l.next;
            }else{
                r.next = head;
                r = r.next;
            }
            head = head.next;
        }

        ListNode newHead = new ListNode(0);
        l.next = right.next;
        r.next =null;
        newHead.next=left.next;
        return newHead.next;
    }
}