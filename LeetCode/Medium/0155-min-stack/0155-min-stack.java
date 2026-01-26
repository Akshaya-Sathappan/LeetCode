class MinStack {
    Deque<Pair> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Pair(val, val));
        }
        else{
            int currentMin = Math.min(stack.peek().mini, val);
            stack.push(new Pair(val, currentMin));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().number;
    }
    
    public int getMin() {
        return stack.peek().mini;
    }
}

class Pair{
    int number;
    int mini;

    Pair(int number, int mini){
        this.number = number;
        this.mini = mini;
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