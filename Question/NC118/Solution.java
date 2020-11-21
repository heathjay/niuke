public class Solution {

    private int cnt;
    private void MergeSort(int[] array, int start, int end){
        if(start >= end) return;
        int mid = (start + end) / 2;
        MergeSort(array, start, mid);
        MergeSort(array, mid+1, end);
        MergoOne(array, start, mind, end);
    }

    private void MergoOne(int[] array, int start, int mid, int end){
        int[] tmp = new int[end - start + 1];
        int k = 0, i = start, j = mid + 1;
        while(i <= mid && j <= end){
//如果前面的元素小于后面的就不能构成逆序对,
            if(array[i] <= array[j]){
                tmp[k++] = array[i];
            }else{
                tmp[k++] = array[j];
                cnt = (cnt + (mid-i+1))%1000000007;
            }
        }

        while(i<=mid){
            tmp[k++] = array[i++];
        }

        while(j<=end){
            tmp[k++] = array[j++];
        }
        for(l=0;l < k; l++){
            array[start++] = tmp[l];
        }
    }
    public int InversePairs(int[] array){
        MergeSort(array, 0, array.length-1);
        return cnt;
    }
}