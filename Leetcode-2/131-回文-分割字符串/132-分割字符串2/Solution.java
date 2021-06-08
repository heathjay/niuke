class Solution {
    boolean[][] f ;
    int n;

    public int minCut(String s) {
        n = s.length();
        if(n == 0) return 0;
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for(int i = n-1; i >=0 ; i--){
            for(int j = i+1; j < n; j++){
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i+1][j-1];
            }
        }


        int[] g = new int[n];
        Arrays.fill(g, Integer.MAX_VALUE);
        for(int i =0; i < n ; i++){
            if(f[0][i]){
                g[i] = 0;
            }else{
                for(int j = 0 ; j < i; j++){
                    if(f[j+1][i]){
                        g[i] = Math.min(g[i], g[j] + 1);
                    }
                }
            }
        }
        return g[n-1];
    }


}