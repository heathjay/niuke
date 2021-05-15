class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] stored = new int[m+n];

        int p1 = 0, p2 = 0;
        int cur = 0;
        while(p1 < m || p2 < n){
            int x = (p1 < m ? nums1[p1] : Integer.MAX_VALUE);
            int y = (p2 < n ? nums2[p2] : Integer.MAX_VALUE);
            if(x < y){
                stored[cur] = x;
                p1++;
            }else{
                stored[cur] = y;
                p2++;
            }
            cur++;
        }
        for(int i = 0 ; i < m+n; i++){
            nums1[i] = stored[i];
        }
        
    }
}