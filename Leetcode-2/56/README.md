56. 合并区间
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

 

示例 1：

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 

提示：

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

List<Intefger> res = new ArraysList<>();
int len = intervals.length;
if(len <= 0) return res;
Arrays.sort(intervals, new Comparator<intervals>(
    @override
    public int compare(intervals o1, intervals o2){
        if(o1[0] < o2[0] ){
            return 1;
        }else if(o1[0] > o2[0]){
            return -1;
        }else{
            return 0;
        }
    }
));

res.add(intervals[0]);
while(i< len-1){
    int j = i+1;
    int end = intervals[i][1];
    while(j < len && tmp > intervals[j][0]){
        j++;
        if(tmp < intervals[j][1]){
            tmp = intervals[j][1];
        }
    }
    res.add(new int[2]{intervals[i][0], tmp})l
    i = j;
}
return res;
