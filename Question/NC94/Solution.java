import java.util.*;


public class Solution {
    /**
     * lfu design
     * @param operators int整型二维数组 ops
     * @param k int整型 the k
     * @return int整型一维数组
     */

    class Node implements Comparable<Node> {
        int cnt;
        int time;
        int key, value;

        Node(int cnt, int time, int key, int value){
            this.cnt = cnt;
            this.time = time;
            this.key = key;
            this.value = value;
        }

        public boolean equals(Object anObject){
            if(this == anObject){
                return true;
            }

            if(anObject instanceof Node){
                Node rhs = (Node) anObject;
                return this.cnt == rhs.cnt && this.time == rhs.time;
            }

            return false;
        }

        public int compareTo(Node rhs){
            return cnt == rhs.cnt? time-rhs.time:cnt-rhs.cnt;
        }
        public int hashCode(){
            return cnt * 1000000007 + time;
        }
    }

    class LFUCache{
        int capacity, time;
        Map<Integer, Node> key_table;
        TreeSet<Node> S;

        public LFUCache(int capacity){
            this.capacity = capacity;
            this.time = 0;
            key_table = new HashMap<Integer, Node>();
            S = new TreeSet<Node>();
        }

        public int get(int key){
            if(capacity == 0){
                return -1;
            }

            if(!key_table.containsKey(key)){
                return -1;
            }

            //从哈系表中获取旧的缓存
            Node cache = key_table.get(key);
            //从平衡二叉树中删除就的缓存
            S.remove(cache);
            cache.cnt += 1;
            cache.time = ++time;
            S.add(cache);
            key_table.put(key,cache);
        }

        public void put(int key, int value){
            if(capacity == 0) return ;
            if(!key_table.containsKey(key)){
                if(key_table.size() == capacity){
                    //从哈希表和平衡二叉树中删除最近使用最少的缓存
                    key_table.remove(S.first().key);
                    S.remove(S.first());
                }
                Node cache = new Node(1, ++time, key, value);
                key_table.put(key,cache);
                S.add(cache);
            }else{
                Node cache = key_table.get(key);
                S.remove(cache);
                cache.cnt+=1;
                cache.time = ++ time;
                cache.value = value;
                S.add(cache);
                key_table.put(key,value);
            }
        }


    }
    public int[] LFU (int[][] operators, int k) {
        // write code here
    }
}