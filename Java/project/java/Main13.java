import java.util.Scanner;


public class Main13{
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        int n = Integer.parseInt(sn.nextLine().trim());
        String[] p ;
        int[] a = new int[n];
        int[] b = new int[n];
        p = sn.nextLine().trim().split(" ");
        //a
        for(int i = 1; i < n;i++){
            a[i] = Integer.parseInt(p[i-1]);
        }
        
         p = sn.nextLine().trim().split(" ");
        //b
        for(int i = 1; i < n; i++){
           b[i] = Integer.parseInt(p[i-1]);
        }
        
        int[] dp = new int[n];
        
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            dp[i] = a[i] * b[i];
        }
        
       System.out.print(dp[0]);
        for(int i = 1; i < n; i++){
            System.out.print(" "+ dp[i]);
        }
    }
}