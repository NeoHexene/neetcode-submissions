class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int interval[] : intervals) {
            pq.offer(interval);
        }
        List<int[]> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            int curr[] = pq.poll();
            if (res.isEmpty()) {
                res.add(curr);
                continue;
            }
            int n = res.size();
            int prev[] = res.get(n - 1);
            if (prev[1] >= curr[0]) {
                curr[0] = Math.min(prev[0], curr[0]);
                curr[1] = Math.max(prev[1], curr[1]);
                res.remove(n - 1);
            }
            res.add(curr);
        }
        return res.toArray(new int[res.size()][]);
    }
}
