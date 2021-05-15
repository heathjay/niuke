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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head == null || head.next == null) return head;
        int n = 1;
        ListNode iter = head;
        while(iter.next != null){
            iter = iter.next;
            n++;
        }
        
        int remain = n - k % n;
        if(remain == n) return head;
        iter.next = head;
        while(remain > 0){
            iter = iter.next;
            remain --;
        }
        ListNode res = iter.next;
        iter.next = null;
        return res;
    }
}