/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList1(ListNode head) {
        if(head == null) return;

        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while(node != null){
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size()-1;
        while(i<j){
            list.get(i).next = list.get(j);
            i++;
            if(i==j) break;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
        
    }


    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        merge(l1,l2);
    }

    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public void merge(ListNode l1, ListNode l2){
        ListNode l1_tmp;
        ListNode l2_tmp;

        while(l1 != null && l2 != null){
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}