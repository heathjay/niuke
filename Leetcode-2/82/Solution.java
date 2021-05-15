
class ListNode{
    ListNode next;
    int val;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
} 
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // ListNode dummy = new ListNode(Integer.MAX_VALUE);
        // dummy.next = head;
        // ListNode slow = dummy;
        // ListNode fast = head;
        
        // while(fast != null){
        //     boolean flag = false;
        //     while(fast.next != null && fast.next.val == fast.val){
        //         fast = fast.next;
        //         flag = true
        //     }
        //     if(flag){
        //         slow.next = fast.next;
        //     }else{
        //         slow.next = fast;
        //     }
        //     fast = fast.next;
        // }
        // return  dummy.next;


        if(head == null) return null;
        ListNode dummy = new ListNode(0, head);
 
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val != cur.next.next.val){
                cur = cur.next;
            }else{
                int val = cur.next.val;
                while(cur.next != null && cur.next.val == val){
                    cur.next = cur.next.next;
                }
            }
        }
        return dummy.next;
    }
}