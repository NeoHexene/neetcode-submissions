class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] res = new int[]{1,1,1};

        for (int[] curr : triplets) {
            if (curr[0] > target[0] || curr[1] > target[1] || curr[2] > target[2]) {
                continue;
            }
            res[0] = Math.max(curr[0], res[0]);
            res[1] = Math.max(curr[1], res[1]);
            res[2] = Math.max(curr[2], res[2]);
        }

        return res[0] == target[0] && res[1] == target[1] && res[2] == target[2];
    }
}
