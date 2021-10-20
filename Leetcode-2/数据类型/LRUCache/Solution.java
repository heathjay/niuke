import java.util.*;
class LRUCache{
    class Node{
        int k, v;
        Node right, left;
        Node(){}
        Node(int k, int v){
            this.k = k;
            this.v = v;
        }

        int capacity;

    }


    int capacity;
    Map<Integer, Node> map;
    Node head, tail;
    public LRUCache(){}
    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.right = tail;
        tail.left = head;
    }



    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            refresh(node);
            return node.v;
        }else{
            return -1;
        }
    }

    public void set(int k ,int v){
        Node node = null;
        if(map.containsKey(k)){
            node = map.get(k);
            node.v = v;
        }else{
            if(map.size() == this.capacity){
                Node oldnode = tail.left;
                map.remove(oldnode.k);
                delete(oldnode);
            }
            node = new Node(k,v);
            map.put(k, node);
        }
        refresh(node);
    }

    public void refresh(Node node){
        delete(node);
        node.right = head.right;
        node.left = head;
        head.right.left = node;
        head.right = node;
    }

    public void delete(Node node){
        if(node.left != null){
            node.left.right = node.right;
            node.right.left = node.left;
        }
    }
    
}

public class Solution{
    public int[] LRU (int[][] operators, int k) {
        List<Integer> res = new ArrayList<>();
        LRUCache lru = new LRUCache(k);
        for(int[] op : operators){
            int type = op[0];
            if(type==1){
                lru.set(op[1], op[2]);
            }else{
                res.add(lru.get(op[1]));
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}