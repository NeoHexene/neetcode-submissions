class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> c1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            c1.put(s1.charAt(i), c1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int req = c1.size();
        for (int i = 0; i < s2.length(); i++) {
            Map<Character, Integer> c2 = new HashMap<>();
            int check = 0;
            for (int j = i; j < s2.length(); j++) {
                char c = s2.charAt(j);
                c2.put(c, c2.getOrDefault(c, 0) + 1);
                if (c1.getOrDefault(c, 0) < c2.get(c)) {
                    break;
                }
                if (c1.getOrDefault(c, 0) == c2.get(c)) {
                    check++;
                }
                if (check == req) {
                    return true;
                }
            }
        }
        return false;
    }
}
