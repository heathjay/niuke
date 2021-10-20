import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5{
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] p = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(p[0]);
        int m = Integer.parseInt(p[1]);
        int k = Integer.parseInt(p[2]);
        p =  reader.readLine().trim().split(" ");
        int[] values = new int[n];
        for(int i = 0; i < n ;i++){
            values[i] = Integer.parseInt(p[i]);
        }
        
        //ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //boolean[] vis = new boolean[n];
        //dfs(values, vis, res, new ArrayList<Integer>(), k, m, n);
        
        //System.out.println(res.size());
        
        if(n < m){
            return;
        }
        int cnt = 0;
        for(int i = 0; i < n - m; i++){
            int j = 0;
            while( j < m){
                if(values[j+i] == -1){
                    break;
                }
                j++;
            }
            if(j == m){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}