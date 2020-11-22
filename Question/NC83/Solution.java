public class Solution {
    public double maxProduct(double[] arr) {
        int len = arr.length;
        if(len == 0 || arr == null) return 0.0;
        int res = arr[0], min = arr[0], max =arr[0];

        for(int i = 1 ; i < len; i++){
            double t_max = max;
            max = Math.max(arr[i] * min, Math.max(arr[i], arr[i] * max));
            min = Math.min(arr[i] * min, Math.min(arr[i], arr[i] * t_max));
            res = Math.max(res,max);
        }

        return res;
    }
}