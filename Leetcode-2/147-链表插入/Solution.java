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
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;

        ListNode dummy = new ListNode(0);

        dummy.next = head;
        ListNode mark = head, cur = head.next;
        while(cur != null){
            if(mark.val <= cur.val){
                mark=mark.next;
            }else{
                ListNode pre = dummy;
                while(pre.next.val <= cur.val){
                    pre = pre.next;
                }
                mark.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = mark.next;
        }
        return dummy.next;
    }
}