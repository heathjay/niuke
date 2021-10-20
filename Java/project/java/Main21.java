import java.util.Scanner;

public class Main21{
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        int num = sn.nextInt();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(num != 0){
            int tmp = num % 10;
            if(cnt != 0 && cnt % 3 == 0){
                sb.append(",");
            }
            sb.append((char)(tmp + '0'));

            num = num / 10;
            cnt++;
        }
        System.out.println(sb.reverse().toString());
    }
}