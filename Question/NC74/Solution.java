public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int len = array.length;
        if(len <= 0 || array == null || k < array[0] || k > array[len - 1]) return 0;

        int left = 0, right = len -1;
        int found = 0;
        int count = 0;
        int mid = 0;
        while(left <= right){
         mid = (left + right) >> 1;
            if(array[mid] == k){
                count ++;
                found = mid;
                break;
            }else if(array[mid] < k){
                left = mid +1;
            }else {
                right = mid - 1;
            }
        }

        for(int i = mid - 1; i >=0 && array[i] == k; i--){
            count++;
        }

        for(int i = mid + 1; i < len && array[i] == k ; i++){
            count++;
        }

        return count;
    }
}