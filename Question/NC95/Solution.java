import java.util.*;


public class Solution {
    /**
     * max increasing subsequence
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int MLS (int[] arr) {
        // write code here


        int len =arr.length;
        if(len == 0 || arr == null){
            return 0;
        }

        Arrays.sort(arr);

        int max = 1;
        int con = 1;
        for(int i = 1; i < len ; i++){
            if(arr[i] == arr[i-1] + 1){
                con ++;
                max = Math.max(max,con);
            }else if(arr[i] == arr[i-1]){
                continue;
            }else{
                con = 1;
            }
        }
        return max;
    }

    public int MLS1 (int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int x : arr){
            if(!map.containsKey(x)){
                int left = map.getOrDefault(x-1,0);
                int right = map.getOrDefault(x+1,0);
                int sum = left + right + 1;
                map.put(x, sum);
                map.put(x- left, sum);
                map.put(x+right, sum);
                max = Math.max(max,sum);
            }
        }
        return max;
    }

}