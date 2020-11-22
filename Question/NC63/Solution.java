public class Solution {
    public boolean isContinuous(int [] numbers) {
        int len = numbers.length;
        if(len < 5) return false;
        int[] cards = new int[14];
        for(int i = 0; i < len; i++){
            cards[numbers[i]] ++;
        } 
        int kings = cards[0];
        int blank = 0;
        for(int i = 1; i <= 9; i++){
            blank = 0;
            for(int j = 0; j <= 4; j++){
                if(cards[i+j] == 0) blank++;
            }
            if(kings >= blank || blank == 0) return true;
        }

        return false;

    }
}