import java.util.*;


public class Solution {
    /**
     * return topK string
     * @param strings string字符串一维数组 strings
     * @param k int整型 the k
     * @return string字符串二维数组
     */
    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        if(null == strings || strings.length == 0) return new String[0][];
        String[][] res = new String[k][];

        //统计出现次数
        Map<String,Integer> cntMap = new HashMap<>();
        for(String s : strings){
            cntMap.put(s, cntMap,getOrDefault(s,0) + 1);
        }

        //初始化堆
        Node[] heapArr = new Node[cntMap.size()+1];

        int idx = 0;
        for(Map.Entry<String,Integer> entry : cntMap.entrySet()){
            Node node = this.new Node(entry.getKey(), entry.getValue());
            heapArr[++idx] = node;
        }

        //调整
        int limit = heapArr.length-1;
        for(int i = 1; i <= k && i <= limit; i++){
            String[] r = new String[]{heapArr[1].val, String.valueOf(heapArr[1].cnt)};
            res[i-1] = r;

            Node tmp = heapArr[1];
            heapArr[1] = heapArr[limit];
            heapArr[limit] = tmp;
            --limit;
            shift(heapArr,1,limit+1);
        }

        return res;
    }
    private void shift(Node[] heapArr, int startIdx, int endIdx){
        int childIdx = 2 * startIdx;
        if(childIdx + 1 < endIdx && heapArr[childIdx+1].compareTo(heapArr[childIdx]) > 0){
            childIdx = childIdx + 1;
        }
        if(childIdx < endIdx && heapArr[childIdx].compareTo(heapArr[startIdx]) > 0){
            Node tmp = heapArr[childIdx];
            heapArr[childIdx] = heapArr[startIdx];
            heapArr[startIdx] = tmp;
            shift(heapArr,childIdx,endIdx);
        }
    }

    class Node implements Comparable<Node>{
        String val;
        int cnt;
        Node(){}
        Node(String val, int cnt){
            this.val = val;
            this.cnt = cnt;
        }

        public int compareTo(Node node){
            if(this.cnt != node.cnt){
                return this.cnt - node.cnt;
            }else{
                return -this.val.compareTo(node.val);
            }
        }
    }
}

/**
 
import java.util.*;


public class Solution {
    class MyNode{
        String val;
        int num;
        MyNode(){}
        MyNode(String val, int num){
            this.val = val;
            this.num = num;
        }
    }
    
    class MyComparator implements Comparator<MyNode>{
        public int compare(MyNode o1, MyNode o2){
            if(o1.num == o2.num){
                //字典序在前所以o1比o2
                return o1.val.compareTo(o2.val);
            }else{
                //数量大的在前
                return o2.num-o1.num;
            }
        }
    }
    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        PriorityQueue<MyNode> queue = new PriorityQueue<>(new MyComparator());
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < strings.length; i++){
            map.put(strings[i], map.getOrDefault(strings[i], 0) + 1);
        }
        
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            queue.add(new MyNode(entry.getKey(), entry.getValue()));
        }
        String[][] res = new String[k][2];
        int j = 0;
        
        while(j < k && !queue.isEmpty()){
            MyNode node =queue.poll();
            res[j][0] = node.val;
            res[j++][1] = String.valueOf(node.num);
        }
        return res;
    }
}


 */