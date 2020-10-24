
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

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = pHead;
        while(node != null){
            if(set.contains(node)){
                return node;
            }else{
                set.add(node);
            }
            node = node.next;
        }
        return null;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode fast = pHead;
        ListNode slow = pHead;
        if(pHead == null || pHead.next == null) return null;
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) break;
        }
        fast = pHead;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }
}