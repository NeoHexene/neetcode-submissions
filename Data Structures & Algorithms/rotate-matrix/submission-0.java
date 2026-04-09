class Solution {
    public void rotate(int[][] matrix) {
        int l = 0, r = matrix.length - 1;

        while (l < r) {
            for (int i = 0; i < r - l; i++) {
                int t = l, b = r;
                int topLeft = matrix[t][l + i]; // save top left element
                matrix[t][l + i] = matrix[b - i][l]; // move bottom left to top left
                matrix[b - i][l] = matrix[b][r - i]; // move bottom right to bottom left
                matrix[b][r - i] = matrix[t + i][r]; // move top right to bottom right
                matrix[t + i][r] = topLeft; // move saved top left to top right
            }
            l++;
            r--;
        }

    }
}
