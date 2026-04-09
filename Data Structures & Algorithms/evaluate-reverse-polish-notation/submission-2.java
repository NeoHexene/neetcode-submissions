class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String s : tokens) {
            System.out.println("Stack: "+st.toString()+" s: "+s);
            if (!st.isEmpty() && "*".equals(s)) {
                int b = st.pop();
                int a = st.pop();
                st.push(a * b);
                continue;
            }
            if (!st.isEmpty() && "+".equals(s)) {
                int b = st.pop();
                int a = st.pop();
                st.push(a + b);
                continue;
            }
            if (!st.isEmpty() && "/".equals(s)) {
                int b = st.pop();
                int a = st.pop();
                st.push(a / b);
                continue;
            }
            if (!st.isEmpty() && "-".equals(s)) {
                int b = st.pop();
                int a = st.pop();
                st.push(a - b);
                continue;
            }
            st.push(Integer.parseInt(s));
        }
        if (st.isEmpty()) {
            return 0;
        }
        return st.pop();
    }
}
