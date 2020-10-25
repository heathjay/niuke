public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> res = new ArrayList<>();
        int len = num.length;
        if(size > len || len == 0 || size == 0) return res;
        int start = 0 , end = size - 1, maxflag = searchMax(num, start, end);
        for(;end < len; end++, start++){
            if(num[end] > num[maxflag]){
                maxflag = end;
                res.add(num[maxflag]);
                continue;
            }
            if(start > maxflag){
                maxflag = searchMax(num,start,end);
                res.add(num[maxflag]);
                continue;
            }
            res.add(num[maxflag]);
        }
        return res;
    }

    public int searchMax(int[] num, int start, int end){
        int flag = start;
        int max = num[start];
        while(start <= end){
            if(num[start] > max){
                flag = start;
                max = num[start];
            }
            start++;
        }
        return flag;
    }

    
}