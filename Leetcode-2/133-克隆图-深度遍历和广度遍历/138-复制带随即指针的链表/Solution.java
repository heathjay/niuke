/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {


    HashMap<Node, Node> visited =new HashMap<>();
    public Node copyRandomList(Node head) {
        
        if(head == null) return head;
        if(visited.containsKey(head)) return visited.get(head);
        
        Node node = new Node(head.val);

        visited.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;

    }
}