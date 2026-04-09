class Solution {
    public int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = currMax + nums[i];
            currMax = Math.max(temp, nums[i]);
            res = Math.max(res, currMax);
        }

        return res;
    }
}
