import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int a = sc.nextInt();
            int m = sc.nextInt();
            int y = sc.nextInt();
            int now = 1;
            int flag = 0;
            for(int i = 1; i <= 60000000; i++){
                now = (now * a) % m;
                if( now % m == y){
                    System.out.println(i);
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) System.out.println("-1");
        }
    }
}