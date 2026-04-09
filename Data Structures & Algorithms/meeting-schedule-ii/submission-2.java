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
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        for (Interval curr : intervals) {
            int currEnd = curr.end;
            int currStart = curr.start;
            if (map.isEmpty()) {
                count += 1;
                map.put(count, currEnd);
            } else {
                boolean placed = false;
                for (int i = 1; i <= count && !placed; i++) {
                    if (map.get(i) <= currStart) {
                        map.put(i, currEnd);
                        placed = true;
                    }
                }
                if (!placed) {
                    count += 1;
                    map.put(count, currEnd);
                }
            }
        }
        return count;
    }
}
