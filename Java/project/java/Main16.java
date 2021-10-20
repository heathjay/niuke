import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    static int[] fa = new int[11000];
	static int[] v = new int[11000];
	static ArrayList<Integer>[] p = new ArrayList[11000];
	static boolean flag = false;
	static int n, m , all = 0;

    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        int T = Integer.parseInt(sn.nextLine().trim());
        String[] ps;
        while(T-- > 0){
            for(int i = 0; i < p.length; i++) p[i] = new ArrayList<>();
            flag = false;
            all = 0;
            for(int i = 0; i < fa.length; i++)fa[i] = -1;
            for(int i = 0; i < v.length; i++) v[i]= 0;
            n = sn.nextInt();
            m = sn.nextInt();
            String tmp = sn.nextLine();
            String s = sn.nextLine();
            ArrayList<Integer> a = new ArrayList<>();
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    int sum = 0;
                    while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                        sum = sum * 10 + s.charAt(i)-'0';
                        i++;
                    }
                    a.add(sum);
                 
                }
            }
            for(int i = 0; i < a.size(); i+=2){
                p[a.get(i)].add(a.get(i+1));
            }
            for(int v = 0; v < p.length; v++){
                for(int i =0; i < p[v].size(); i++){
                    int w = p[v].get(i);
                    int xp = find(v);
                    int yp = find(w);
                    if(xp == yp){
                        flag = true;
                        break;
                    }
                    union(v,w);
                }
                if(flag) break;
            }
            if(flag) System.out.println("No");
            else{
                for(int i = 0; i < a.size(); i+=2){
                    p[a.get(i+1)].add(a.get(i));
                }
                dfs(1);
                if(all <n){
                    System.out.println("No");
                }
                else System.out.println("Yes");
            }
        }
    }

	public static int find(int x){
        if(fa[x] == -1) return x;
        return find(fa[x]);
    }
	public static void union(int x , int y){
        int xp = find(x);
        int yp = find(y);
        fa[xp] = yp;
    }

	public static void dfs(int cur){
        all++;
        v[cur] = 1;
        for(int i = 0 ; i < p[cur].size(); i++){
            int vv=p[cur].get(i);
            if(v[vv] == 0) dfs(vv);
        }
    }
}