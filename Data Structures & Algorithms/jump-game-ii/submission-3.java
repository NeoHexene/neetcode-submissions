class Solution {

    private int[] dp;

    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, 10000000);
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int i) {
        if (i == nums.length - 1) {
            dp[i] = 0;
            return dp[i];
        }
        if (nums[i] == 0 || dp[i] != 10000000) {
            return dp[i];
        }
        int reach = Math.min(nums.length - 1, i + nums[i]);
        for (int j = i + 1; j <= reach; j++) {
            System.out.println("dp["+i+"]: "+dp[i]);
            dp[i] = Math.min(dp[i], 1 + dfs(nums, j));
            System.out.println("dp["+i+"]: "+dp[i]);
        }
        return dp[i];
    }
}
