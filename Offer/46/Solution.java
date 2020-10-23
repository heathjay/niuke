import java.util.ArrayList;
/*
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        //前一个坐标初始化为0 记pre
        //pre = (pre + m - 1) % n--;
        if(n < 1 || m < 1){
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(i);
        }
        int pre = 0;
        while(list.size() > 1){
            pre = (pre + m - 1) % list.size();
            list.remove(pre);
        }
        return list.get(0);
    }
}
*/
public class Solution{
    public int LastRemaining_Solution(int n, int m) {
        if(n <= 0 || m <= 0) return -1;
        return n == 1 ? 0 :(LastRemaining_Solution(n-1, m) + m) % n;
    }
}