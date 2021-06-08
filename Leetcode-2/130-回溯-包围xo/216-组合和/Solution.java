class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k,n, new ArrayList<Integer>(), 0);
        return res;
    }
    public void dfs( int k, int n, List<Integer> path, int start){
        if(path.size() == k){
            int sum = 0;
            for(Integer num : path){
                sum+= num;
            }
            if(sum == n) res.add(new ArrayList<>(path));
        }


        for(int i = start; i < 9 ; i++){
                if(i > n) continue;
                path.add(i+1);
                dfs(k , n, path,i+1);
                path.remove(path.size()-1);
       
            
        }

    }
}