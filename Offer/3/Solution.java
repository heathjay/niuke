
public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}


import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(listNode == null ) return list;
        while(listNode != null){
            int val = listNode.val;
            list.add(0,val);
            listNode = listNode.next;
        }
        return list;
    }

    //递归
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        back(list, listNode);
        return list;
    }
    public void back(ArrayList<Integer> list, ListNode listNode){
        if(listNode == null ) return;
        back(list, listNode.next);
        int val = listNode.val;
        list.add(val);
    }
}