import java.util.*;


  public class ListNode {
    int val;
    ListNode next = null;
  }
 

public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
       if(head == null || head.next == null || k==1) return head;
       ListNode res = new ListNode(0);
       res.next = head;
       int length = 0;
       ListNode pre = res;
       ListNode cur = head;
       ListNode temp = null;
       while(head!=null){
           length++;
           head=head.next;
       }
       for(int i=0;i < length / k; i++){
            //头插   
        for(int j = 1;j < k ; j++){
               temp = cur.next;
               cur.next = temp.next;
               temp.next = pre.next;
               pre.next = temp;

           }
           pre = cur;
           cur = cur.next;
       }
       return res.next;
    }
}