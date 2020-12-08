import java.util.ArrayList;
public class Solution {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        int len = S.length;
        if(len == 0 || S == null) return res;
        ArrayList<Integer> tmp = new ArrayList<>();
        dfs(S, 0, tmp);
        return res;
    }

    public void dfs(int[] s, int start, ArrayList<Integer> tmp){
        res.add(new ArrayList<Integer>(tmp));
        for(int i = start; i < s.length; i++){
            tmp.add(s[i]);
            dfs(s,i+1,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}