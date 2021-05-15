class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(len == 0) return new int[]{1};
        int remain = 1;
        for(int i = len - 1; i >= 0 ; i--){
            int sum = digits[i] + remain;
            remain = sum / 10;
            digits[i] = sum % 10;
        }
        if(digits[0] == 0 ){
            digits = new int[len+1];
            digits[0]=1;
        }
        return digits;
 
   }
   public plusOne1(int[] digits){
       for(int i = digits.length - 1; i >= 0 ; i--){
           digits[i]++;
           digits[i] = digits[i] % 10;
           if(digits[i] != 0) return digits;
       }
       digits = new int[digits.length+1];
       digits[0] = 1;
       return digits;
   }
}