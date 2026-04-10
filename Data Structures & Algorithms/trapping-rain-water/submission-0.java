class Solution {
    public int trap(int[] height) {
        int[] lmax = new int[height.length];
        lmax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }
        int[] rmax = new int[height.length];
        rmax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }

        int amount = 0;

        for (int i = 0; i < height.length; i++) {
            int min = Math.min(lmax[i], rmax[i]);
            amount += min - height[i];
        }

        return amount;
    }
}
