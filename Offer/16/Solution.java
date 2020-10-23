
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null || list2 == null) return (list1 == null) ? list2 : list1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val) {
                curr.next = list2;
                list2 = list2.next;
            }else{
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }
        if(list1 != null) curr.next = list1;
        if(list2 != null) curr.next = list2;
        return dummy.next;
    }
}