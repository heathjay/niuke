class Solution{
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int i = 0, idx = 0;
        //前无重叠
        //Ri < L
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            res[idx++]=intervals[i++];
        }
        //重叠
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res[idx++]=newInterval;
        //后无重叠
        while(i < intervals.length){
            res[idx++] = intervals[i++];
        }
        return Arrays.copyOf(res,idx);
    }
}