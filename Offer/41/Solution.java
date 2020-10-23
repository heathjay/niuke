import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       for(int i = 1; i < sum;i++){
           int temp = 0;
           int j = i;
           while(temp < sum){
               temp += j;
               j++;
           }
           if(temp == sum){
               ArrayList<Integer> newArray = new ArrayList<>();
               for(int k=i; k < j; k++){
                   newArray.add(k);
               }
               result.add(newArray);
           }
       }
       return result;
    }
}

//递归
