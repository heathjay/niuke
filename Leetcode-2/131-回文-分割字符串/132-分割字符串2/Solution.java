class Solution {
    boolean[][] f ;
    int n;
    List<String> ans = new ArrayList<>();
    int minT ;
    public int minCut(String s) {
        n = s.length();
        if(n == 0) return 0;
        minT = n-1;
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for(int i = n-1; i >=0 ; i--){
            for(int j = i+1; j < n; j++){
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i+1][j-1];
            }
        }
        dfs(s,0);
        return minT;
    }

    public void dfs(String s, int i){
        if(i == n){
            minT = Math.min(minT, ans.size()-1);
            ans = new ArrayList<String>();
            return;
        }

        for(int j = i; j <n ;j++){
            if(f[i][j]){
                ans.add(s.substring(i,j+1));
                dfs(s, j+1);
                ans.remove(ans.size() -1);
            }
        }
    }
}