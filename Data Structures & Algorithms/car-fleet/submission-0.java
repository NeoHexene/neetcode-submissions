class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[0] - a[0]));
        for (int i = 0; i < position.length; i++) {
            pq.add(new int[]{position[i], speed[i]});
        }
        int[] first = pq.poll();
        double prevTime = (double) (target - first[0]) / first[1];
        int fleet = 1;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            double currTime = (double) (target - curr[0]) / curr[1];
            if (currTime > prevTime) {
                prevTime = currTime;
                fleet++;
            }
        } 
        return fleet;
    }
}
