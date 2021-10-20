import java.util.Scanner;
import java.util.HashMap;


public class Main11{
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        int T = Integer.parseInt(sn.nextLine().trim());
        String[] p;
        int n, m;

        for(int i = 0 ; i < T ; i++){
            HashMap<Character, int[]> map = new HashMap<>();
            p = sn.nextLine().trim().split(" ");
            n = Integer.parseInt(p[0]);
            m = Integer.parseInt(p[1]);
            String s;
            char[] cs;
            for(int j = 0 ; j < n ; j ++){
                s = sn.nextLine();
                cs = s.toCharArray();
                for(int k = 0; k < cs.length ; k++){
                    map.put(cs[k], new int[]{j, k});
                }
            }
            
            s = sn.nextLine();
            cs = s.toCharArray();
            int x = 0, y = 0;
            int sum = 0;
            for(int j = 0 ; j < s.length();j++){
                int nextx = map.get(cs[j])[0];
                int nexty = map.get(cs[j])[1];
                sum += (nextx - x) + (nexty - y) + 1;
                x = nextx;
                y = nexty;
                System.out.print(x + " " + y +" ");
            }
            System.out.println(sum);
        }
            
    }
}