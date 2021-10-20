import java.util.Scanner;
public class Main12{
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        int len = Integer.parseInt(sn.nextLine().trim());
        String s = sn.nextLine().trim();
        
        if(len < 4){
            return;
        }
        int cnt = 0, left = 0;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == 'M'){
                cnt++;
            }
            if(s.charAt(i) == 'T'){
                if(cnt >= 1){
                    left = i;
                     break;
                }
            }
        }
        cnt = 0;
        int right = 0;
        for(int i = len-1; i >left; i--){
            if(s.charAt(i) == 'T'){
                cnt++;
            }
            if(s.charAt(i) == 'M'){
                if(cnt >= 1){
                    right = i;
                     break;
                }
            }
        }
        System.out.println(s.substring(left, right+1));
    }
}