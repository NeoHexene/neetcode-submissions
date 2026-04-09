class Solution {
    public int missingNumber(int[] nums) {
        int ideal = 0;
        for (int i = 0; i <= nums.length; i++) {
            ideal ^= i;
        }
        int actual = 0;
        for (int n : nums) {
            actual ^= n;
        }
        return ideal ^ actual;
    }
}
