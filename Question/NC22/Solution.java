public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        int res = m+n-1;
        if(ptr1 < 0){
            A[res] = B[ptr2];
            ptr2--;
            res--;
        }
        while(ptr1 >=0 && ptr2 >= 0){
            if(A[ptr1] >= B[ptr2]){
                A[res] = A[ptr1];
                ptr1--;
            }else{
                A[res] = B[ptr2];
                ptr2--;
            }
            res--;
        }

        if(ptr1 >=0){
            return;
        }
        if(ptr2 >= 0){
            A[res] = B[ptr2];
            res--;
            ptr2--;
        }

        return;
    }
}