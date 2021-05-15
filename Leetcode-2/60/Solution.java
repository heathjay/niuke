import java.util.LinkedList;
import java.util.List;


class Solution {
    public String getPermutation(int n, int k) {
        k--;

        int[] factor = new int[n];
        factor[0]=1;
        for(int i = 1; i < n ; i++){
            factor[i] = factor[i-1] * i;
        }

        List<Integer> nums = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >= 0; i--){
            int index = k / factor[i];
            sb.append(nums.remove(index));
            k -= index * factor[i];
        }
        return sb.toString();
    }
}