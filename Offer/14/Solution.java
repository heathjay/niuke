
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0; i < k ; i++){
            if(fast == null){
                return null;
            }
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}