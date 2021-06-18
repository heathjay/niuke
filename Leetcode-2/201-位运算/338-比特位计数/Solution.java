class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
    
        for(int i = 0; i < n+1; i++){
           res[i] = countn(i); 
        }
        return res;
    }

    public int countn(int n){
        int count =0;
        while(n != 0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
}