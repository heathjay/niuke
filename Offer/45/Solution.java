public class Solution {
    public boolean isContinuous(int [] numbers) {
        int len = numbers.length;
        if(len < 4) return false;
        int[] cups = new int[14];
        for(int i = 0 ; i < len; i++){
            cups[numbers[i]] ++;
        }
        int kingsLeft = cups[0];
        int blankNum = 0;
        for(int i = 1; i <= 9; i++){
            blankNum= 0;
            for(int j = 0; j < 5; j++){
                if(cups[i+j] == 0) blankNum++;
            }
            if(kingsLeft >= blankNum || blankNum == 0) return true;            
        }
        return false;
    }
}