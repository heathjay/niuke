class Solution{
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int n = tokens.length;
    
        for(int i = 0; i < n ; i++){
            String cur = tokens[i];
    
            if(isNumber(cur)){
                stack.push(Integer.parseInt(cur));
            }else{
                int ops2 = stack.pop();
                int ops1 = stack.pop();
                switch (cur) {
                    case "+":
                        stack.push(ops1 + ops2);
                        break;
                    case "-":
                        stack.push(ops1 - ops2);
                        break;
                    case "*":
                        stack.push(ops1 * ops2);
                        break;
                    case "/":
                        stack.push(ops1 / ops2);
                        break;
                    default:
                }
    
            }
        }
        return stack.pop();
    }
    
    public boolean isNumber(String cur){
        return !("+".equals(cur) || "-".equals(cur) || "*".equals(cur) || "/".equals(cur));
    }
}
    