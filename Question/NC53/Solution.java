import java.util.*;


  public class ListNode {
    int val;
    ListNode next = null;
  }
 

public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @param n int整型 
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while(n > 0){
            if(fast!= null){
                fast = fast.next;
            }else{
                return null;
            }
            n--;
        }

        if(fast == null){
            return head.next;
        }

        while(fast != null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
            if(fast == null){
                pre.next = slow.next;
            }
        }
        return head;
    }
}