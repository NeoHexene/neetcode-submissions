class Solution {
    public int search(int[] nums, int target) {
        int le = 0;
        int ri = nums.length - 1;
        while(le <= ri) {
            int mi = le + (ri - le) / 2;
            if (nums[mi] == target) {
                return mi;
            }
            if (nums[le] <= nums[mi]) {
                if (nums[le] <= target && target <= nums[mi]) {
                    ri = mi - 1;
                } else {
                    le = mi + 1;
                }
            } else {
                if (nums[mi] <= target && target <= nums[ri]) {
                    le = mi + 1;
                } else {
                    ri = mi - 1;
                }
            }
        }
        return -1;
    }
}
