class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        char[] ch = s.toCharArray();
        int preNum=getValue(ch[0]);
        for(int i = 1; i < ch.length; i++){
            int num = getValue(ch[i]);
            if(preNum < num){
                sum -= preNum;
            }else{
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
    public int getValue(char c){
        switch (c) {
            case 'M': return 1000;
            case 'D': return 500;
            case 'C' : return 100;
            case 'L' : return 50; 
            case 'X' : return 10;
            case 'V' : return 5; 
            case 'I': return 1;
            default: return 0;
        }
    }
}