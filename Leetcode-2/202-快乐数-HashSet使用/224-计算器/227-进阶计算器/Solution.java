class Solution{
    public int calculate(String s) {
        int len = s.length();
        char[] str = s.toCharArray();
        Stack<Integer> st_num = new Stack<>();
        char op = '#';
        int ans = 0, sign = 1;


        for(int i = 0; i < len ; i++){
            if(str[i] == ' ') continue;
            if(str[i] >= '0' && str[i] <= '9'){
                int num = str[i] - '0';
                while(i + 1 < len && str[i+1] >= '0' && str[i+1] <= '9'){
                    num = num* 10 + str[++i] - '0';
                }
                if(op != '#'){
                    if(op == '*') num *= st_num.pop();
                    else num = st_num.pop() / num;
                    op = '#';
                }
                st_num.push(num);
            }
            else if(str[i] == '*' || str[i] == '/') op = str[i];
            else{
                ans += st_num.pop()*sign;
                sign = str[i] == '+' ? 1 : -1;
            }
        }
        return ans + st_num.pop() * sign;


    }
}