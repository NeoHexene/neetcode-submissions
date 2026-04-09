class MinStack {

    Stack<Integer> st = null;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        if (!st.isEmpty()) {
            return st.peek();
        } else {
            return -1;
        }
    }
    
    public int getMin() {
        return Collections.min(st);
    }
}
