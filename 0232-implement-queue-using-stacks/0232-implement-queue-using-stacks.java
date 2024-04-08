class MyQueue {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        
        int value = outStack.pop();
        
        while(!outStack.isEmpty()){
            inStack.push(outStack.pop());
        }
        
        return value;
    }
    
    public int peek() {
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        
        int value = outStack.peek();
        
        while(!outStack.isEmpty()){
            inStack.push(outStack.pop());
        }
        
        return value;
    }
    
    public boolean empty() {
        return inStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */