import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @return ListNode类
     */
    public ListNode insertionSortList (ListNode head) {
        // write code here
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        
        ListNode cur = head;
        while(cur != null){
            ListNode pre = dummy;
            ListNode next = cur.next;
            while(pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }
            
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}