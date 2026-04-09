class Solution {
    public int maxArea(int[] heights) {
        int le = 0;
        int ri = heights.length - 1;
        int ans = 0;
        while (le < ri) {
            int len = ri - le;
            int bre = heights[le] < heights[ri] ? heights[le] : heights[ri];
            ans = Math.max(len * bre, ans);
            if (heights[ri] > heights[le]) {
                le += 1;
            } else {
                ri -= 1;
            }
        }
        return ans;
    }
}
