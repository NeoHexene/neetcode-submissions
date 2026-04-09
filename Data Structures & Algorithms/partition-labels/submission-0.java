class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int l = 0, r = 0;
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.get(c) - 1);
            set.add(c);
            boolean satisfied = true;
            for (Character cs : set) {
                if (map.get(cs) != 0) {
                    satisfied = false;
                    break;
                }
            }
            if (satisfied) {
                res.add(r - l + 1);
                set.clear();
                l = r + 1;
            }
            r+=1;
        }
        return res;
    }
}
