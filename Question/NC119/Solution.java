import java.util.Arrays;
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(k <= 0 || k > input.length) return res;
        for(int i = 1; i < k;i++){
            int j = i -1;
            int unFindElement = input[i];
            while(j >= 0 && input[j] > unFindElement){
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = unFindElement;
        }
        for(int i = k; i < input.length;i++){
            if(input[i] < input[k-1]){
                int newK = input[i];
                int j = k-1;
                while(j >= 0 && input[j] > newK){
                    input[j+1] = input[j];
                    j--;
                }
                input[j+1] = newK;
            }
        }
        for(int i = 0; i < k ; i++){
            res.add(input[i]);
        }
        return res;
    }


}