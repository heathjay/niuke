import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
       cur.next = head;
        while(head != null){
           ListNode tail = head;
         
           for(int i = 1; i <k;i++){
               tail= tail.next;
               if(tail ==null){
                   return dummy.next;
               }
           }
            ListNode next = tail.next;
            tail.next = null;
            reverse(head);
            cur.next = tail;
            head.next = next;
            cur = head;
            head = next;
        }
        if(head != null) cur.next = head;
        return dummy.next;
    }
    
    public void reverse(ListNode head){
        
        ListNode pre = null;
        
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        
       
    }
}