
public class Solution {
    public void reOrderArray(int [] array) {
        int len = array.length;
        if(len <= 1) return;
        int j = 0;
        int num = 0;
        for(int i = 0; i < len; i ++){
            if(array[i] % 2 ==1){
                j = i;
                while(j > num){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    j--;
                }
                num++;
            }
        }
    }
}