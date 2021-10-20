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
     public ListNode sortList (ListNode head) {
        // write code here
        //快慢指针到中间
        if(head == null || head.next == null) return head;
        ListNode slow=head, fast=head;
        ListNode preSlow=head;
        while(fast != null && fast.next != null){
            preSlow=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        
        ListNode listA = head;
        ListNode listB=slow;
        preSlow.next = null;
        listA= sortList(listA);
        listB= sortList(listB);
        return merge(listA,listB);
    }
    public ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(-1);
        ListNode l1 = a;
        ListNode l2 = b;
        ListNode cur = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }
        
        return dummy.next;
    }
}
