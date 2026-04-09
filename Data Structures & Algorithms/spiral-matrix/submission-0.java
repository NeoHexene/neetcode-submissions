class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int t = 0, b = matrix.length - 1;
        int l = 0, r = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (t <= b && l <= r) {
            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            t += 1;
            for (int i = t; i <= b; i++) {
                res.add(matrix[i][r]);
            }
            r -= 1;
            if (!(l <= r && t <= b)) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res.add(matrix[b][i]);
            }
            b -= 1;
            for (int i = b; i >= t; i--) {
                res.add(matrix[i][l]);
            }
            l += 1;
        }
        return res;
    }
}
