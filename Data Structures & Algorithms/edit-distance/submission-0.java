class Solution {

    private Integer[][] dp;

    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length() + 1][word2.length() + 1];
        return dfs(word1, word2, 0, 0);
    }

    private int dfs(String word1, String word2, int i, int j) {

        if (i == word1.length() && j == word2.length()) {
            dp[i][j] = 0;
            return 0;
        }
        if (i == word1.length()) {
            dp[i][j] = word2.length() - j;
            return word2.length() - j;
        }
        if (j == word2.length()) {
            dp[i][j] = word1.length() - i;
            return word1.length() - i;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int res = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            res = dfs(word1, word2, i + 1, j + 1);
        } else {
            int insert = dfs(word1, word2, i, j + 1);
            int delete = dfs(word1, word2, i + 1, j);
            int replace = dfs(word1, word2, i + 1, j + 1);
            res = insert < delete && insert < replace ? insert : delete < replace ? delete : replace;
            res += 1;
        }
        dp[i][j] = res;
        return res;
    }
}
