import java.util.*;


  public class ListNode {
    int val;
    ListNode next = null;
  }
 

public class Solution {
    /**
     * 
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList (ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);    // 建立哨兵，用于减少一些不必要的非空判断
        dummy.next = head;
        ListNode sortedTail = dummy;    // 已排序区的尾端节点，用于往已排序区的尾端添加min节点
        while (sortedTail.next != null) {    // sortedTail.next指向的是未排序区的头部，sortedTail.next为空表示未排序区已清空，结束循环
            ListNode prev = sortedTail;    // curr的前一个节点，用于获取minPrev
            ListNode curr = sortedTail.next;    // curr指向未排序区头部节点，准备开始遍历整个未排序区
            ListNode minPrev = prev;    // min节点的前一个节点，从未排序区删除min节点的时候需要用到
            ListNode min = curr;
            while (curr != null) {
                if (curr.val < min.val) {
                    minPrev = prev;
                    min = curr;
                }
                prev = curr;
                curr = curr.next;
            }
            minPrev.next = min.next;    // 从未排序区删除min节点
            min.next = sortedTail.next;    // 更新未排序区的头部节点，与下面两行代码配合使用
            sortedTail.next = min;    // 把min节点添加到已排序区尾端
            sortedTail = sortedTail.next;    // 更新已排序区尾端节点
        }
        return dummy.next;
    }
}