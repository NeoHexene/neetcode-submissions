class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> tf = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tf.put(c, tf.getOrDefault(c, 0) + 1);
        }

        int res[] = new int[]{-1,-1};
        int reslen = Integer.MAX_VALUE;

        Map<Character, Integer> sf = new HashMap<>();
        int l = 0;
        int req = tf.size();
        int ava = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            sf.put(c, sf.getOrDefault(c, 0) + 1);

            if (tf.containsKey(c) && tf.get(c) == sf.get(c)) {
                ava++;
            }

            while (ava == req) {
                if ((r - l + 1) < reslen) {
                    reslen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char lc = s.charAt(l);
                sf.put(lc, sf.get(lc) - 1);
                if (tf.containsKey(lc) && sf.get(lc) < tf.get(lc)) {
                    ava--;
                }
                l++;
            }
        }
        return reslen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
