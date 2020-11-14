import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回表达式的值
     * @param s string字符串 待计算的表达式
     * @return int整型
     */

     public int solve (String s) {
        // write code here

        Stack<Integer> stack = new Stack<>();
        int sum = 0, number = 0;
        char sign = '+';
        char[] charArray = s.toCharArray();

        for(int i = 0, n = charArray.length; i < n; i++){
            char c = charArray[i];
            if(c == '('){
                int j = i + 1;
                int counterPar = 1;
                while(counterPar > 0){
                    if(charArray[j] == '('){
                        counterPar++;
                    }
                    if(charArray[j] == ')'){
                        counterPar--;
                    }
                    j++;
                }
                number = solve(s.substring(i+1, j-1));
                i = j -1;
            }
            if(Character.isDigit(c)){
                number = number * 10 + c - '0';
            }
            if(!Character.isDigit(c) || i == n-1){
                if(sign == '+'){
                    stack.push(number);
                }else if(sign == '-'){
                    stack.push(-1*number);
                }else if(sign == '*'){
                    stack.push(stack.pop() * number);
                }else if(sign == '/'){
                    stack.push(stack.pop() / number);
                }
                number = 0;
                sign = c;
            }

        }
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}