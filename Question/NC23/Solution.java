import java.util.*;


  public class ListNode {
    int val;
    ListNode next = null;
  }
 

public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @param x int整型 
     * @return ListNode类
     */
    public ListNode partition (ListNode head, int x) {
        // write code here
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p = dummy, q = dummy2;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                p.next = cur;
                p = p.next;
            }else{
                q.next = cur;
                q = q.next;
            }
            cur = cur.next;
        }

        p.next = dummy2.next;
        q.next = null;
        return dummy.next;
    }
}