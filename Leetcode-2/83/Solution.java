public class ListNode{
    int val;
    ListNode next;
    ListNode(){
    
    }
    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class Solution{
    public ListNode deleteDuplicates(ListNode head){
        if(head == null) return head;

        ListNode dummy = new ListNode(Integer.MAX_VALUE, head);
        ListNode cur = dummy;
        while(cur != null && cur.next != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}