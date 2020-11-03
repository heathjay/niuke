public class Solution {
    public boolean[][] flag;
    public int count = 0;
    public int movingCount(int threshold, int rows, int cols){
        flag = new boolean[rows][cols];
        help(0,0,threshold, rows, cols);
        return count;
    }
    public boolean isValid(int prow, int pcol, int threshold){
        int sum =0;
        while(prow != 0){
            sum += prow %10;
            prow= prow /10;
        }
        while(pcol != 0){
            sum += pcol % 10;
            pcol = pcol /10;
        }
        return sum != threshold;
    }
    public void help(int prow, int pcol, int threshold, int rows, int cols){
        if(prow < 0|| pcol < 0 || prow >= rows || pcol >= cols || flag[prow][pcol]) return;
        if(!isValid(prow,pcol,threshold)){
            flag[prow][pcol]= true;
            return;
        }
        flag[prow][pcol] = true;
        count++;
        help(prow+1, pcol, threshold, rows, cols);
        help(prow, pcol+1, threshold, rows, cols);

    }

}