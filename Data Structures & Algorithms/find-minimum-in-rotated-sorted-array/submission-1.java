class Solution {
    public int findMin(int[] nums) {
        int le = 0;
        int ri = nums.length - 1;
        while (le < ri) {
            int mi = le + (ri - le) / 2;
            if (nums[mi] < nums[ri]) {
                ri = mi;
            } else {
                le = mi + 1;
            }
        }
        return nums[le];
    }
}
