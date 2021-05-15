import java.util.List;
import java.util.ArrayList;
Class Solution{
    public int[][] merge(int[][] intervals){
        if(intervals.length == 0){
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            int L = intervals[i][0], R = intervals[i][1];
            if(res.size() == 0 || res.get(res.size()-1)[1] < L){
                res.add(new int[]{L,R});
            }else{
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size()-1)[1], R);
            }
        }        
        return res.toArray(new int[res.size()-1][]);
    }
}