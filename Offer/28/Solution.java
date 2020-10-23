import java.utils.Arrays;
public class Solution {
    public int MoreThanHalfNum_Solution1(int [] array) {
            Arrays.sort(array);
            int len = array.length;
            int cond = array[len / 2];
            int cnt = 0;
            for(int i = 0; i < len ; i++){
                if(cond == array[i]) ++cnt;
            }
            if(cnt > len / 2) return cond;
            return 0;
        }
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        int cond = -1 ;
        int cnt = 0;
        for(int i = 0; i < array.length; i++){
            if(cnt == 0){
                cond = array[i];
                ++cnt;
            }
            else{
                if(cond == array[i]) ++cnt;
                else --cnt;
            }
        }
        cnt =0;
        for(int i = 0; i < array.length;i++){
            if(cond == array[i]) ++cnt;
        }
        if(cnt > array.length / 2) return cond;
        return 0;
    }
}