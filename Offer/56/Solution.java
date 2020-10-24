
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
/*
import java.util.HashSet;
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null) return null;
        HashSet<Integer> set = new HashSet<>();
        ListNode pre = pHead;
        ListNode cur = pHead.next;
        while(cur != null){
            if(cur.val == pre.val){
                set.add(cur.val);
            }
            pre = cur;
            cur = cur.next;
        }
        //头指针需要进行检验
        while(pHead != null && set.contains(pHead.val)){
            pHead = pHead.next;
        }
        if(pHead == null){
            return null;
        }
        pre = pHead;
        cur = pHead.next;
        while(cur != null){
            if(set.contains(cur.val)){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead;
    }
}
*/

public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;

        while(cur != null){
            if(cur.next != null && cur.next.val == cur.val){
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }

        return head.next;
    }
}