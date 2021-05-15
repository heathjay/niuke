public class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class Solution{
    public ListNode reverseBetween(ListNode head, int left, int right){
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        if(left > right) return null;
        if(left == right) return head;
        
        ListNode pre = dummy;
        ListNode next = null;
        for(int i = 0; i < left - 1;i++){
            pre = pre.next;
        }
        next = pre;
        for(int i = 0; i < right - left +1; i++ ){
            next = next.next;
        }
        ListNode lefthead = pre.next;
        ListNode righthead = next.next;
        pre.next = null;
        next.next = null;
        reverse(lefthead);


        pre.next = next;
        lefthead.next = righthead;
        return dummy.next;

    }

    public void reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null ){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
    }
}