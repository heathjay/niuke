import java.util.Scanner;
import java.util.HashSet;
public class Main8{
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        int M = sn.nextInt();
        int N = sn.nextInt();
        HashSet<Integer> set = new HashSet<>();
        int cnt = 0;
        
        for(int i = M; i <= N; i++){
            int tmp = i;
            int F = tmp%10;
            tmp/=10;
            int E = tmp%10;
            if(E==F) continue;
            tmp/=10;
            int D = tmp%10;
            if(D==E||D==F) continue;
            tmp/=10;
            int C = tmp%10;
            if(C==D||C==E||C==F) continue;
            tmp/=10;
            int B = tmp%10;
            if(B==C||B==D||B==E||B==F) continue;
            tmp/=10;
            int A = tmp%10;
            if(A==B||A==C||A==D||A==E||A==F) continue;
            tmp/=10;
            if((A*10+B)+(C*10+D)==(E*10+F)){
                cnt++;
            }
            System.out.println(A * 10 + B + C * 10 + D);
        }
        
        System.out.println(cnt);
    }
}