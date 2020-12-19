/**
 * Definition for singly-linked list.
 */

 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    /*
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len == 0 || lists == null) return null;
        ListNode p = lists[0];
        for(int i = 1; i < len; i++){
            p = mergeTwo(p,lists[i]);
        }
        return p;
    }
    public ListNode mergeTwo(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null) return null;
        ListNode dummy = new ListNode(-1);
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
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
    */

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    public ListNode merge(ListNode[] lists, int l, int r){
        if(l == r){
            return lists[l];
        }
        if(l > r){
            return null;
        }
        int mid = (r + l)/ 2;
        return mergeTwo(merge(lists,l,mid), merge(lists,mid+1,r));
    }

    public ListNode mergeTwo(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null) return null;
        ListNode dummy = new ListNode(-1);
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
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}