class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // rows
        int n = matrix[0].length; // cols
        for (int row[] : matrix) {
            if (row[0] == target || target == row[n-1]) {
                return true;
            } else {
                if (row[0] < target && target < row[n-1]) {
                    return helper(row, target);
                }
            }
        }
        return false;
    }

    private boolean helper (int arr[], int target) {
        int le = 0;
        int ri = arr.length;
        while (le < ri) {
            int mid = le + (ri - le) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                le = mid + 1;
            } else {
                ri = mid;
            }
        }
        return false;
    }
}
