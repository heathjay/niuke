import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> res = new ArrayList<>();
        int len = num.length;
        if(len == 0 || num == null || size == 0 || size > len) return res;

        int start = 0, end = size - 1;
        int maxflag = searchMax(start, end, num);
        for(; end < len; end++, start++){
            if(num[end] > num[maxflag]){
                maxflag = end;
                res.add(num[maxflag]);
                continue;
            }
            if(start > maxflag){
                maxflag = searchMax(start, end, num);
                res.add(num[maxflag]);
                continue;
            }
            res.add(num[maxflag]);

        }
        return res;
    }
    public int searchMax(int start, int end, int[] num){
        int flag = start;
        int max = num[start];
        while(start<=end){
            if(num[start] > max){
                max = num[start];
                flag = start;
            }
            start++;
        }
        return flag;
    }

}