import java.util.Stack;

public class Solution {
    Stack<Integer> stackTotal = new Stack<Integer>();
    Stack<Integer> stackLittle = new Stack<Integer>();

    
    public void push(int node) {
        stackTotal.push(node);
        if(stackLittle.empty()){
            stackLittle.push(node);
        }else{
            if(node <= stackLittle.peek()){
                stackLittle.push(node);
            }else{
                stackLittle.push(stackLittle.peek());
            }
        }
    }
    
    public void pop() {
        stackLittle.pop();
        stackTotal.pop();
    }
    
    public int top() {
            return stackTotal.peek();
    }
    
    public int min() {
        return stackLittle.peek();
    }
}