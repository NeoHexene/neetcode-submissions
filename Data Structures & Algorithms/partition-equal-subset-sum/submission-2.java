class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        if (total % 2 != 0) {
            return false;
        }
        Set<Integer> sums = new HashSet<>();
        sums.add(0);
        for (int i = nums.length - 1; i >= 0 ; i--) {
            Set<Integer> temp = new HashSet<>();
            for (Integer s : sums) {
                if (s + nums[i] == total / 2) {
                    return true;
                }
                temp.add(s+nums[i]);
                temp.add(s);
            }
            sums = temp;
        }
        return sums.contains(total / 2);
    }
}
