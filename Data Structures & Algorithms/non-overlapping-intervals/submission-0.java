class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int curr[] = intervals[i];
            if (curr[0] < end) {
                end = Math.min(curr[1], end);
                count += 1;
            } else {
                end = curr[1];
            }
        }
        return count;
    }
}
