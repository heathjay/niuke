import java.util.*;


  public class ListNode {
    int val;
    ListNode next = null;
  }
 

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 
     * @param head ListNode类 
     * @return ListNode类
     */
    public ListNode oddEvenList (ListNode head) {
        // write code here
        if(head == null || head.next == null){
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddCur = oddHead;
        ListNode evenCur = evenHead;

        while(evenCur != null && evenCur.next != null){
            oddCur.next = evenCur.next;
            oddCur = oddCur.next;
            evenCur.next = oddCur.next;
            evenCur = evenCur.next;
        }

        oddCur.next = evenHead;
        return head;
    }
}