class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh += 1;
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        int time = 0;
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (fresh > 0 && !q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                int curr[] = q.poll();
                int row = curr[0];
                int col = curr[1];
                for (int[] dir :  directions) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] != 1) {
                        continue;
                    }
                    grid[r][c] = 2;
                    fresh -= 1;
                    q.add(new int[]{r, c});
                }
            }
            time += 1;
        }
        return fresh != 0 ? -1 : time;
    }
}
