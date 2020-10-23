import java.util.HashMap;
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = pHead;

        while(p != null){
            RandomListNode newNode = new RandomListNode(p.label);
            map.put(p, newNode);
            p = p.next;
        }
        p = pHead;
        while(p != null){
            RandomListNode node = map.get(p);
            node.next = (p.next == null) ? null : map.get(p.next);
            node.random = (p.random == null) ? null : map.get(p.random);
            p = p.next;
        }
        return map.get(pHead);
    }
}