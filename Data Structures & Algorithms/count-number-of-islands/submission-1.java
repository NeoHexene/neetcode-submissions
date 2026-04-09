class Solution {
    private Set<String> visited = new HashSet<>();

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited.contains(i+","+j)) {
                    updateVisited(i, j, grid);
                    count += 1;
                }
            }
        }
        return count;
    }

    private void updateVisited (int row, int col, char[][] grid) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || visited.contains(row+","+col)) {
            return;
        }
        visited.add(row+","+col);
        if (grid[row][col] == '1') {
            updateVisited(row - 1, col, grid); // prev row
            updateVisited(row + 1, col, grid); // next row
            updateVisited(row, col - 1, grid); // prev col
            updateVisited(row, col + 1, grid); // next col
        }
        return;
    }
    
}
