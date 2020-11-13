import java.util.*;


  public class ListNode {
    int val;
    ListNode next = null;
  }
 

public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @param m int整型 
     * @param n int整型 
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
   if(m > n) return null;
        if(m == n) return head;
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        int count = 0;
        while(count < m-1){
            pre = pre.next;
            count++;
        }
        ListNode cur = pre.next;
        while(cur != null && count < n-1){
            ListNode tmp = cur.next;
            if(tmp == null) {            
                break;
            }
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
            count++;
        }

        return dummy.next;
    }
}