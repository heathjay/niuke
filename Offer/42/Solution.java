import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        
        int mul = Integer.MAX_VALUE;
        int i = 0, j = array.length-1;
        while(i <j){
            int sumv = array[i] + array[j];
            if(sumv > sum){
                j--;
            }else if(sumv < sum){
                i++;
            }else{
                if(mul > array[i] * array[j]){
                    mul = array[i] * array[j];
                    res.clear();
                    res.add(array[i]);
                    res.add(array[j]);
                }
                i++;
            }
        }
        return res;   
    }
}