class Solution {
    private int[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        visited = new int[grid.length][grid[0].length];
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] != 1) {
                    area = Math.max(area, calculate(i, j, grid, 0));
                }
            }
        }
        return area;
    }

    private int calculate (int row, int col, int[][] grid, int area) {
        System.out.println("Row: "+row+" Col: "+col+" Area: "+area);
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || visited[row][col] == 1) {
            return area;
        }
        visited[row][col] = 1;
        if (grid[row][col] == 0) {
            return area;
        }
        int up = calculate (row - 1, col, grid, 0);
        int left = calculate (row, col - 1, grid, 0);
        int down = calculate (row + 1, col, grid, 0);
        int right = calculate (row, col + 1, grid, 0);
        area = up + left + right + down + grid[row][col];
        return area;
    }
}
