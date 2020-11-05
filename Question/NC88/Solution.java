/*
import java.util.*;

public class Finder {
    public int findKth(int[] a, int n, int K) {
        // write code here
        return quickSort(a, 0, n-1, K);
    }
    private int quickSort(int[] a, int start, int end, int k){
        int temp = a[start];
        int s = start, e = end;
        while(s < e){
            while(s < e && temp >= a[e]) e--;
            a[s] = a[e];
            while(s < e && temp <= a[s])s++;
            a[e] = a[s];
        }
        a[s] = temp;
        if(s == k -1){
            return a[s];
        }else if(s > k - 1){
            return quickSort(a, start, s-1, k);
        }else{
            return quickSort(a,s+1,end,k);
        }
    }
}
*/

import java.util.*;
 
public class Finder {
    public int findKth(int[] a, int n, int K) {
        for(int i = n / 2 -1; i>=0; i--){
            heapify(a, n, i);
        }
        for(int i = n - 1; i >= n - K; i--){
            swap(a, 0, i);
            heapify(a,i, 0);
        }
        return a[n-K];
    }

    private void heapify(int[] a, int n, int k){
        int temp = a[k];
        int t = 2 * k + 1;
        while(t < n){
            if(t + 1 < n && a[t] < a[t+1]){
                t++;
            }
            if(temp < a[t]){
                a[k] = a[t];
                k = t;
                t = 2 * k + 1;
            }else{
                break;
            }
        }
        a[k]=temp;
    }

    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}