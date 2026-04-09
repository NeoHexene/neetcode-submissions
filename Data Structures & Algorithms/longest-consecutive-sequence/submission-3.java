class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
        int prev = pq.poll();
        int maxLen = 1;
        int length = 1;
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            System.out.println("Curr: "+curr+" Prev: "+prev+" Length: "+length+" MaxLen: "+maxLen);
            if (curr - prev == 1) {
                length++;
                prev = curr;
            } else if (curr - prev == 0) {
                continue;
            } else {
                prev = curr;
                length = 1;
            }
            maxLen = Math.max(maxLen, length);
        }
        return maxLen;
    }
}
