class Solution {

    public void solve(char[][] grid) {
        helper(grid);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                } else if (grid[i][j] == 'S') {
                    grid[i][j] = 'O';
                }
            }
        }
    }

    private void helper(char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1 && grid[i][j] == 'O') {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!q.isEmpty()) {
            int curr[] = q.poll();
            int row = curr[0], col = curr[1];
            if (grid[row][col] == 'O') {
                grid[row][col] = 'S';
                for (int[] dir : directions) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] != 'O') {
                        continue;
                    }
                    q.offer(new int[]{r, c});
                }
            }
            
        }
    }
}
