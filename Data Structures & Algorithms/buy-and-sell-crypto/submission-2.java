class Solution {
    public int maxProfit(int[] prices) {
        int min = 101;
        int max = 0;
        int minInd = -1;
        int maxInd = -1;
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
                minInd = i;
            }
            if (max < prices[i]) {
                max = prices[i];
                maxInd = i;
            }
            if (maxInd < minInd && maxInd != -1) {
                maxInd = -1;
                max = 0;
            }
            if (minInd < maxInd && minInd != -1) {
                ans = Math.max(ans, max - min);
            }
        }
        return ans;
    }
}
