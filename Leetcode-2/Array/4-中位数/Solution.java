class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int total = length1+ length2;
        if(total % 2 == 1){
            return getK(nums1,nums2, total / 2+1);
        }else{
            double median1 = total / 2 , median2 = total / 2 +1;
            return (getK(nums1, nums2, total/2) + getK(nums1, nums2,median2))/2;
        }
    }

    public double getK(int[] nums1, int[] nums2, int k ){
        int length1 = nums1.length, length2 = nums2.length;

        int index1 = 0, index2 = 0;

        while(true){
            if(index1 == length1){
                return nums2[index2 + k -1];
            }
            if(index2 == length2){
                return nums1[index1 + k -1];
            }

            if(k == 1){
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1+half , length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;

            int t1 = nums1[newIndex1], t2 = nums2[newIndex2];
            if(t1 <= t2){
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }else{
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }

        }
    }
    
}