class Solution {
    //动态规划
    public int numTrees(int n) {
        //G(n) = F(0) + ... + F(n)
        //G(0) = 1
        //G(1) = 1
        //F(i, n) = G(i-1) * G(n-i)
        //G(n) = G(0) * G(n) + G(1) * G(n-1) ...+ G(n-1) * G(0)
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for(int i =2; i <= n; i++){
            for(int j = 1; j <= i;j++){
                G[i] = G[j] * G[i-j];
            }
        }   
        return G[n]; 
    }
}