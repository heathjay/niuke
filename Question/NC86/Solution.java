import java.util.*;

public class Finder {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        int[] res = new int[2];
        if(n==0 ) return res;
        if(mat == null) return res;
     
        //从右上角开始
        int i = 0;
        int j = m - 1;
        while(i <= n - 1 && j >= 0){
            if(mat[i][j] == x){
                res[0] = i;
                res[1] = j;
                return res;
            }

            else if(x >mat[i][j]){
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
}