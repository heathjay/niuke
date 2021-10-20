import java.util.Scanner;
import java.util.ArrayList;
public class Main14{
    static int n;
    static int[] v = new int[13];
	static ArrayList<Integer> list = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        n = sn.nextInt();
        dfs(0);
        for(ArrayList<Integer> an : ans){
            for(Integer integer : an){
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

	public static void dfs(int cur){
        if(ans.size() >= 100) return;
        if(cur == n){
            for(int i = 0; i < list.size(); i++){
                if(i + 1 == list.get(i)) return;
            }
            
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < list.size(); i++){
                tmp.add(list.get(i));
            }
            ans.add(tmp);
            return;
        }
        for(int i = 1; i <= n; i++){
            if(v[i] == 0){
                v[i] = 1;
                list.add(i);
                dfs(cur+1);
                list.remove(list.size()-1);
                v[i] = 0;
            }
        }
    }
}
