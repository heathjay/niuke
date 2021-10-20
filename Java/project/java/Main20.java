import java.util.Scanner;

public class Main20{
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        String p = sn.nextLine();
        String s = sn.nextLine();
        
        int lens = s.length();
        int lenp = p.length();
        boolean[][] dp = new boolean[lens+1][lenp+1];
        dp[0][0] = true;
        for(int i = 1; i <= lenp; i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-1];
            }else if(p.charAt(i-1) == '#'){
                dp[0][i] = dp[0][i-1];
            }
        }

        for(int i = 1; i <= lens; i++){
            for(int j = 1; j <= lenp; j++){
                char pc = p.charAt(j-1);
                char sc = s.charAt(i-1);
                if(pc == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else if(pc == '?' || pc == sc){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pc == '#'){
                    dp[i][j] = dp[i-1][j-1] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        if(dp[lens][lenp]){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}