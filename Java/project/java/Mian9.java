import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Main{
    //以parent为父亲节点的子节点总数
    static int[] children;
    static int[] weight;
    static int[] min;
    static int[] max;
    static boolean[] vis;
    static HashMap<Integer, ArrayList<Integer>> map;
    static int maxDif = -1;
    static int node = -1;
    public static void main(String[] args) throws IOException{
        //Scanner sn = new Scanner(System.in);
        BufferedReader  reader = new BufferedReader(new InputStreamReader(System.in));
        String[] p = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(p[0]);
        int k = Integer.parseInt(p[1]);
        children = new int[n+1];
        min = new int[n+1];
        max = new int[n+1];
        vis = new boolean[n+1];
        map = new HashMap<Integer, ArrayList<Integer>>();
        weight = new int[n+1];
        p = reader.readLine().trim().split(" ");
        for(int i = 1; i <= n; i++){
            weight[i] = Integer.parseInt(p[i-1]);
        }
        ArrayList<Integer> list;
        for(int i = 1; i <= n-1 ; i ++){
            p = reader.readLine().trim().split(" ");
            int x = Integer.parseInt(p[0]);
            int y = Integer.parseInt(p[1]);
            //更新树
            if(!map.containsKey(x)){
                list = new ArrayList<>();
                list.add(y);
                map.put(x, list);
            }else{
                list = map.get(x);
                list.add(y);
                map.put(x, list);
            }
            
            if(!map.containsKey(y)){
                list = new ArrayList<>();
                list.add(x);
                map.put(y, list);
            }else{
                list = map.get(y);
                list.add(x);
                map.put(y, list);
            }
        }
       
        int start = Integer.parseInt(reader.readLine());
        dfs(start, k);
        System.out.println(node);
    }
    
    public static void dfs(int parent, int k){
       if(!vis[parent]){
            vis[parent] = true;
            max[parent] = weight[parent];
            min[parent] = weight[parent];
            children[parent] =1;
            for(int i = 0; i < map.get(parent).size(); i++){
                int child = map.get(parent).get(i);
                if(!vis[child]){
                    dfs(child, k);
                    max[parent] = Math.max(max[child], max[parent]);
                    min[parent] = Math.min(min[child], min[parent]);
                    children[parent] += children[child];
                    
                }
            }
            
            if( children[parent] <= k && max[parent] - min[parent] >= maxDif){
                if(max[parent] - min[parent] > maxDif){
                    maxDif = max[parent] - min[parent];
                    node = parent;
                }else{
                    node = node == -1? parent: Math.min(node, parent);
                }
            }
       }
    }
}