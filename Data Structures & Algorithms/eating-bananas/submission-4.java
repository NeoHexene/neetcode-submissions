class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > k) {
                k = piles[i];
            }
        }
        int l = 1;
        int r = k;
        while (l <= r) {
            int mid = (r + l) / 2;
            long hours = 0;
            for (int i = 0; i < piles.length; i++) {
                hours += Math.ceil((double) piles[i] / mid);
            }
            if (hours <= h) {
                k = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return k;
    }
}
