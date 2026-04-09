class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int size = 0;
        int end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            size += 1;
            end = Math.max(end, map.get(s.charAt(i)));
            if (i == end) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
