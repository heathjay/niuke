import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main{
    public  static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        String s = sn.nextLine().trim();
        int len = s.length();
        Map<Integer, Integer> map = new HashMap<>();
        int state = 0;
        int maxlen = 0;
        map.put(0, -1);
        
        for(int i = 0 ; i < len; i++){
            if(s.charAt(i) == 'a') state ^= 0x000001;
            if(s.charAt(i) == 'b') state ^= 0x000010;
            if(s.charAt(i) == 'c') state ^= 0x000100;
            if(s.charAt(i) == 'x') state ^= 0x001000;
            if(s.charAt(i) == 'y') state ^= 0x010000;
            if(s.charAt(i) == 'z') state ^= 0x100000;
            if(map.containsKey(state)){
                maxlen = Math.max(maxlen, i-map.get(state));
            }else{
                map.put(state, i);
            }
            
        }
        System.out.println(maxlen);
    }
}