class Solution {
    public int countDigitOne(int n) {
        int low = 0;
        int high = n;
        int cur = 0;
        int num = 1;
        int count = 0;

        while(high != 0 || cur != 0){
            cur = high % 10;
            high = high / 10;
            if(cur == 0) count+= num* high;
            else if(cur == 1) count += high * num + 1 + low;
            else  count += (high+1)*num;
            low = cur*num + low;
            num *= 10;
        }
        return count;
    }
}