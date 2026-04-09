class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int prev_1 = 1;
        int prev = 2;
        int curr = 0;
        for (int i = 3; i <= n; i++) {
            curr = prev + prev_1;
            prev_1 = prev;
            prev = curr;
        }
        return curr;
    }
}
