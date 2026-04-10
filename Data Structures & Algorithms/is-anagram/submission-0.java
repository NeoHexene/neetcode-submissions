class Solution {
    public boolean isAnagram(String s, String t) {
        return helper(s).equals(helper(t));
    }

    private String helper(String s) {
        int[] sf = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sf[s.charAt(i) - 'a']++;
        }
        return Arrays.toString(sf);
    }
}
