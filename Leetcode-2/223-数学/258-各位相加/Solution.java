class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
      
        while(num > 9){
            int tmp = 0;
            while( num!= 0){
                tmp+= num % 10;
                num = num /10;
            }
            num = tmp;
        }
        return num;
    }
}