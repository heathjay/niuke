import java.util.*;


  public class ListNode {
    int val;
    ListNode next = null;
  }
 

public class Solution {
    /**
     * 
     * @param l1 ListNode类 
     * @param l2 ListNode类 
     * @return ListNode类
     */
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        if(l1 == null || l2 == null) return l1 == null? l2 : l1;
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                res.next = l1;
                res = res.next;
                l1 = l1.next;
                continue;
            }

            else if(l1.val >= l2.val){
                res.next = l2;
                res = res.next;
                l2 = l2.next;
            }
        }
        if(l1 != null)res.next=l1;
        if(l2 != null)res.next = l2;
        return dummy.next;
    }
}