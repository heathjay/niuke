import java.util.ArrayList;
import java.util.Arrays;


public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = num.length;
        if(n == 0 || num == null) return res;
        Arrays.sort(num);

        for(int first = 0 ; first < n ; first++){
            //找到与上次枚举不同的数
            if(first > 0 && num[first] == num[first-1]){
                continue;
            }

            //c对应的指针最右
            int third = n-1;
            int target =- num[first];
            //枚举b
            for(int second = first + 1; second < n; second++){
                if(second > first + 1 && num[second] == num[second - 1]){
                    continue;
                }
                while(second < third && num[second] + num[third] > target){
                    --third;
                }
                if(second == third){
                    break;
                }
                if(num[second] + num[third] == target){
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(num[first]);
                    tmp.add(num[second]);
                    tmp.add(num[third]);
                    res.add(tmp);
                }
            }
        }
    }
}