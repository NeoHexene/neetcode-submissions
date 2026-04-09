class Solution {

    private String helper (String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public String longestPalindrome(String s) {
        String res = null;
        int resLen = 0;
        for (int i = 0; i < s.length(); i++) {
            String tempOdd = helper(s, i, i);
            String tempEven = helper(s, i, i+1);
            if (tempOdd.length() > resLen) {
                res = tempOdd;
                resLen = tempOdd.length();
            }
            if (tempEven.length() > resLen) {
                res = tempEven;
                resLen = tempEven.length();
            }
        }
        return res;
    }
}
