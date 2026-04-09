class Solution {
    private Set<String> visited = new HashSet<>();

    public List<String> findWords(char[][] grid, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            boolean found = false;
            for (int i = 0; i < grid.length && !found; i++) {
                for (int j = 0; j < grid[i].length && !found; j++) {
                    if (grid[i][j] == word.charAt(0)) {
                        visited.clear();
                        if (helper(i,j,grid,word,0)) {
                            res.add(word);
                            found = true;
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean helper (int row, int col, char[][] grid, String word, int idx) {
        if (row == grid.length || col == grid[0].length || row < 0 || col < 0 || visited.contains(row+","+col)) {
            return false;
        }
        if (idx == word.length() - 1 && grid[row][col] == word.charAt(idx)) {
            return true;
        }
        if (grid[row][col] == word.charAt(idx)) {
            visited.add(row+","+col);
            boolean prevRow = helper(row - 1, col, grid, word, idx + 1);
            boolean prevCol = helper(row, col - 1, grid, word, idx + 1);
            boolean nextRow = helper(row + 1, col, grid, word, idx + 1);
            boolean nextCol = helper(row, col + 1, grid, word, idx + 1);
            return prevRow || prevCol || nextRow || nextCol;
        } else {
            return false;
        }
    }
}
