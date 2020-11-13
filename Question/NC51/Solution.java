
//  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
import java.util.ArrayList;
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        if(lists == null || lists.size == null) return dummy.next;
        ListNode curr = dummy;
        for(int i = 0; i < lists.size();i++){
            curr= mergerTwoLists(curr,lists.get(i));
        }
        return dummy.next;
    }
    public ListNode mergerTwoLists(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return (l1 == null) ? l2 : l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 == null){
            curr.next = l2;
        }
        if(l2 == null){
            curr.next = l1;
        }

        return dummy.next;
    }
}