class MinStack {
    Deque<Integer> stack;
    Deque<Integer> stackMin;
    /** initialize your data structure here. */
    public MinStack() {
       stack = new LinkedList<>();
       stackMin= new LinkedList<>();
       stackMin.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        stack.push(val);
        stackMin.push(Math.min(stackMin.peek(),val));
    }
    
    public void pop() {
        stack.pop();
        stackMin.pop();
    }
    
    public int top() {
       return stack.peek();
    }
    
    public int getMin() {
        return stackMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */