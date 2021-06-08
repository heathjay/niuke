class Solution {
    
    public int calculate(String s) {
        Stack<Integer> num_s = new Stack<>();
        Stack<Integer> sign_s = new Stack<>();
        int len = s.length();
        if(len <= 0) return 0;
        char[] str = s.toCharArray();
        int sign = 1;
        int ans = 0;
        
        for(int i =0; i < len ; i++){
            if(str[i] == ' ')continue;
            if(str[i] == '-' || str[i] == '+') sign = str[i] == '+' ? 1 : -1;
            else if(str[i] >= '0' && str[i] <= '9'){
                int num = str[i] - '0';
                while(i+1 <len && str[i+1] >= '0' && str[i+1] <= '9'){
                    num = num*10 + str[++i]-'0';
                }
                ans+=sign* num;
            }else if(str[i] == '('){
                num_s.push(ans);
                sign_s.push(sign);
                ans = 0;
                sign = 1;
            }else{
                ans = num_s.pop()+ans*sign_s.pop();
            }

        }
        return ans;
    }
}