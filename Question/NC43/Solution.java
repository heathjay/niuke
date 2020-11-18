import java.util.ArrayList;
public class Solution {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    boolean[] visited ;
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if(num.length == 0 || num == null) return res;
        ArrayList<Integer> path = new ArrayList<>();
        visited = new boolean[num.length];
        dfs(num,  visited,path);
        return res;
    }

    public void dfs(int[] num, boolean[] visited, ArrayList<Integer> path){
        if(path.size() == num.length){
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for(int i = 0; i < num.length; i++){
            if(visited[i]) continue;
            else{
                visited[i] = true;
                path.add(num[i]);
                dfs(num, visited, path);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }
    }
}