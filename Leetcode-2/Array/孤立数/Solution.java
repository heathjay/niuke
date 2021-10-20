import java.util.*;


public class Solution {
    /**
     * 
     * @param A int整型一维数组 
     * @return int整型
     */
    public int singleNumber (int[] A) {
        // write code here
        
//         Arrays.sort(A);
//         int len = A.length;
//         int i = 0;
//         while(i < len){
//             if(i == len-1 || A[i] !=A[i+1]){
//                 return A[i];
//             }else{
//                 i = i+3;
//             }
//         }
//         return 0;
        int len = A.length;
        if(len < 1) return -1;
        int res = 0;
        for(int i = 0; i < 32; i++){
            int tmp = 0;
            for(int j = 0; j < len; j++){
                tmp += (A[j] >> i) & 1;
            }
            res += (tmp % 3)<<i;
        }
        return res;
    }
}