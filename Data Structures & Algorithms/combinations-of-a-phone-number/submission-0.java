class Solution {
    private String[] digitToChar = {
        "", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };

    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        backtrack(0, digits, "");
        return res;
    }

    private void backtrack(int idx, String digits, String curr) {
        if (curr.length() == digits.length()) {
            res.add(curr);
            return;
        }
        String chars = digitToChar[digits.charAt(idx) - '0'];
        for (char c : chars.toCharArray()) {
            backtrack(idx + 1, digits, curr + c);
        }
    }
}
