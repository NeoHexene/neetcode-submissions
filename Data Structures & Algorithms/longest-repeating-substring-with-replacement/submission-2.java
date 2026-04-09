class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int maxLen = 0;
        int maxFreq = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
            maxFreq = Math.max(count.get(s.charAt(j)), maxFreq);
            while ((j - i + 1) - maxFreq > k) {
                count.put(s.charAt(i), count.get(s.charAt(i)) - 1);
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}
