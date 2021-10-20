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
     * @param head1 ListNode类 
     * @param head2 ListNode类 
     * @return ListNode类
     */
    public ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre=head;
            head=next;
        }
        return pre;
    }
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        ListNode l1 = reverse(head1);
        ListNode l2 = reverse(head2);
        ListNode res=new ListNode(-1);
        ListNode cur = res;
        int cn = 0;
        while(l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int val = x + y + cn;
            cn = val / 10;
            ListNode tmp = new ListNode(val % 10);
            cur.next = tmp;
            cur = tmp;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;    
        }
        if(cn != 0){
            ListNode tmp = new ListNode(1);
            cur.next = tmp;
            cur =tmp;
        }
        return reverse(res.next);
    }
}