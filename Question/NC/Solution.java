import java.util.*;


public class Solution {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    private Map<Integer,Node> map = new HashMap<>();
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    private int k;

    public int[] LRU (int[][] operators, int k) {
        // write code here
        this.k = k;
        head.next = tail;
        tail.prev = head;
        int len = (int) Arrays.stream(operators).filter(x -> x[0] == 0).
    }
}