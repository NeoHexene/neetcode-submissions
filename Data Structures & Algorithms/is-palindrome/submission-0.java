class Solution {
    public boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            if (Character.isLetterOrDigit(s.charAt(lo)) && Character.isLetterOrDigit(s.charAt(hi))) {
                if (Character.toLowerCase(s.charAt(lo)) != Character.toLowerCase(s.charAt(hi))) {
                    return false;
                } else {
                    lo += 1;
                    hi -= 1;
                }
            } else if (Character.isLetterOrDigit(s.charAt(lo))) {
                hi -= 1;
            } else {
                lo += 1;
            }
        }
        return true;
    }
}
