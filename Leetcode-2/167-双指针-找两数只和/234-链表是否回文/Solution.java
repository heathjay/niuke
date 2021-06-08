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
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow =head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
       

        ListNode second = reverse(slow.next);
        slow.next = null;
        ListNode p1 = head;
        ListNode p2 = second;
        boolean result = true; 
        while(p2 != null && result){
            if(p2.val != p1.val){
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        p2 = reverse(second);
        slow.next = p2;
        return result;

    }
    public ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}