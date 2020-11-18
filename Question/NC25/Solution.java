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
        if(head == null || head.next == null)return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while(head != null){
            if(curr.val == head.val){
                while(head != null && head.val == curr.val){
                    head = head.next;
                }
                curr.next =head;
                if(head == null) break;
            }
            curr = curr.next;
            head = head.next;
        }
        return dummy.next;
    }
}