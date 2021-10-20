import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class Main{
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        int T = Integer.parseInt(sn.nextLine());
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "10");
        map.put(3, "11");
        map.put(4, "100");
        map.put(5, "101");
        map.put(6, "110");
        map.put(7, "111");
        map.put(8, "1000");
        map.put(9, "1001");
        for(int i = 0 ; i < T ; i++){
            int x = Integer.parseInt(sn.nextLine());
            StringBuilder sb = new StringBuilder();
            int maxD = 1;
            while(x / maxD >10){
                maxD *= 10;
            }
            
            while(x > 0){
                int num = x / maxD;
                sb.append(map.get(num));
                x = x - num * maxD;
                maxD = maxD /10;
            }
            
            sb.reverse();
            int j = 0;
            while(j < sb.length()){
                if(sb.charAt(j) == '1'){
                    break;
                }
                j++;
            }
            
            String s = sb.substring(j);
            
            StringBuilder res = new StringBuilder();
            res.append(s.charAt(0));
            for(int k = 1; k < s.length(); k++){
                if(res.charAt(res.length()-1) == s.charAt(k)){
                    continue;
                }else{
                    res.append(s.charAt(k));
                }
            }
            System.out.println(res.toString());
        }
    }
}