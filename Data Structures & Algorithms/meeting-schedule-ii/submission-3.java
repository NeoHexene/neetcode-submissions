/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return 0;
        }
        if (intervals.size() == 1) {
            return 1;
        }
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Interval curr : intervals) {
            if (pq.isEmpty()) {
                pq.offer(curr.end);
            } else {
                if (pq.peek() <= curr.start) {
                    pq.poll();
                    pq.offer(curr.end);
                } else {
                    pq.offer(curr.end);
                }
            }
        }
        return pq.size();
    }
}
