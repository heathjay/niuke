import java.util.*;

public class Solution {
    /*维护k链表*/
    public int findKth1(int[] a, int n, int K) {
        // write code here
        LinkedList<Integer> que = new LinkedList<Integer>();
        int len = a.length;
        
        for(int i = 0; i < len; i++ ){
            if(que.size() < K){
                if(que.size() == 0){
                    que.addFirst(a[i]);
                }else{
                    //有序插入
                    insert(que, a[i]);
                }
            }else{
                if(a[i] < que.get(0)){
                    continue;
                }else{
                    insertex(que, a[i]);
                }
                
            }
        }
        return que.getFirst();
    }
    public void insert(LinkedList<Integer> que, int a){
        int len = que.size();
        for(int i = 0 ; i < len; i++){
            if(que.get(i) > a){
                que.add(i, a);
                return;
            }
        }
        que.addLast(a);
    }
    public void insertex(LinkedList<Integer> que, int a){
        int len = que.size();
        que.remove(0);
        insert(que, a);
    }

/**
 * 
 * 
 * 快速排列 + 2 分法
 * 
 */
public int findKth(int[] a, int n, int K) {
    return quickSort(a, 0, n-1 , K);
}
public int quickSort(int[] a, int start, int end, int K){
    if(start < end){
        int key = a[start];
        int i = start;
        for(int j = i + 1; j <= end; j++){
            if(a[j] > key){
                i++;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }

        a[start] = a[i];
        a[i] = key;
        if(K == i - start + 1){
            return a[i];
        }else if( K < i - start + 1){
            return quickSort(a, start, i - 1, K);
        }else{
            return quickSort(a, i + 1, end, K - (i - start +1));
        }
    }

    return a[end];
}
    
}


