class Solution {
    public List<Integer> getRow1(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i <= rowIndex; i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j==0 || j == i){
                    tmp.add(1);
                    continue;
                }
                tmp.add(res.get(res.size()-1).get(j-1) + res.get(res.size()-1).get(j));
            
            }
            res.add(new ArrayList<>(tmp));
        }
        return res.get(res.size()-1);
    }
}