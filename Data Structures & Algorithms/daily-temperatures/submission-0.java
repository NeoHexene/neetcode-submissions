class Solution {
    public int[] dailyTemperatures(int[] deg) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[deg.length];
        for (int i = 0; i < deg.length; i++) {
            while (!st.isEmpty() && deg[st.peek()] < deg[i]) {
                int top = st.pop();
                ans[top] = i - top;
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int top = st.pop();
            ans[top] = 0;
        }
        return ans;
    }
}
