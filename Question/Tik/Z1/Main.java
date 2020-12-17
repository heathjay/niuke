import java.util.Scanner;
public class Main{
    public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    final int mod = 1000000007;
    int[] p = new int[n + 1];
    int[] dp = new int[n + 2];
    for(int i = 1; i <= n ; i++){
        p[i] = in.nextInt();
    }
    for(int i = 2; i <= n+1;i++){
        dp[i] = dp[i-1] * 2 - dp[p[i-1]] + 2;
        if(dp[i] < 0) dp[i] += mod;
        else if(dp[i] >= mod) dp[i] %= mod;
    }
    System.out.println(dp[n+1]);
}
}
