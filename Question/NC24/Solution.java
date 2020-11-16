import java.util.*;


  public class ListNode {
    int val;
    ListNode next = null;
  }
 

public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;
        ListNode curr = head;
        while(curr != null && curr.next != null){
           if(curr.val == curr.next.val){
               ListNode tmp = curr.next;
               while(tmp != null && tmp.val == curr.val){
                   tmp = tmp.next;
               }
               pre.next = tmp;
               curr = tmp;
           }else{
               pre = pre.next;
               curr = curr.next;
           }
        }
        return dummy.next;
    }
}