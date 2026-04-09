class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMax = 1, currMin = 1;

        for (int n : nums) {
            int tempMax = currMax * n;
            int tempMin = currMin * n;
            currMax = Math.max(n, Math.max(tempMin, tempMax));
            currMin = Math.min(n, Math.min(tempMin, tempMax));
            res = Math.max(currMax, res);
        }
        return res;
    }
}
