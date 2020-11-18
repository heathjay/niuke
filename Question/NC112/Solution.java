import java.util.*;


public class Solution {
    /**
     * 进制转换
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public String solve (int M, int N) {
        // write code here

        Stack<Integer> stack = new Stack();

        if(M == 0) return "0";

        StringBuilder sb = new StringBuilder();
        if(M < 0){
            sb.append("-");
        }

        M = Math.abs(M);

        while(M != 0){
            stack.push(M % N);
            M = M / N;
        }

        int n = stack.size();

        for(int i = 0; i < n; i++){
            if(stack.peek() >9){
                sb.append((char)(stack.pop() - 10 + 'A'));
            }else{
                sb.append(stack.pop());
            }

        }
        return String.valueOf(sb);
    }
}