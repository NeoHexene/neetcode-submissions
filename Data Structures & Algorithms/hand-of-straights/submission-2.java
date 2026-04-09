class Solution {
    public boolean isNStraightHand(int[] hand, int size) {
        if (hand.length % size != 0) {
            return false;
        }
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            freq.put(hand[i], freq.getOrDefault(hand[i], 0) + 1);
        }
        Arrays.sort(hand);
        for (int h : hand) {
            if (freq.get(h) > 0) {
                for (int i = h; i < h + size; i++) {
                    if (!freq.containsKey(i) || freq.get(i) == 0) {
                        return false;
                    }
                    freq.put(i, freq.get(i) - 1);
                }
            }
        }
        return true;
    }
}
