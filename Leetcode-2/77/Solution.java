class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> path = new LinkedList<>();
        if(k<0 || k >n) return res;
        backtrace(path, n, k, 1);
        return res;
    }

    public void backtrace(List<Integer> path, int n, int k,int start){
        if(path.size() + n-start + 1 < k){
            return;
        }
        if(path.size() == k){
            res.add(new LinkedList(path));
            return;
        }
        for(int i = start; i <= n ; i++){
                path.add(i);
                backtrace(path, n, k, i+1);
                path.remove(path.size()-1);
        }
    }
}