class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for(int i = 1;i < s.length();i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) =='(' ){
                    dp[i] = (i >= 2 ? dp[i-1] :0 )  + 2; 
                }else if(i - dp[i-1] > 0 && s.charAt(i-1-dp[i-1]) =='('){
                    dp[i] = dp[i-1] + ((i-dp[i-1]) >= 2 ? dp[i-dp[i-2]-2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
    public int longestValidParentheses1(String s) {

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i =0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}