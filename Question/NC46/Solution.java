import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        int len = num.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(len == 0 || num == null ) return res;
        Arrays.sort(num);
        if(target < num[0]) return res;
        ArrayList<Integer> list = new ArrayList<>();
        backtrace(num, res, target, new ArrayList<Integer>(), 0,0);
        return res;
    }

    public void backtrace(int[] num, ArrayList<ArrayList<Integer>> res, int target, ArrayList<Integer> tmp, int idx, int sum){
        if(sum == target){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }else if(sum  >  target ){
            return;
        }


        for(int i = idx; i < num.length; i ++){
            if( (i > idx && num[i] == num[i-1] )){
                continue;
            }
            if(target > sum){
                tmp.add(num[i]);
                sum+= num[i];
                backtrace(num, res, target, tmp, i+1,sum);
                tmp.remove(tmp.size()-1);
                sum -= num[i];
            }
        }
        return;
    }
}