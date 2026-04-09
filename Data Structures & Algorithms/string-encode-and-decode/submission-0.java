class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int len = s.length();
            sb.append((char)len);
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int len = (int) str.charAt(i);
            list.add(str.substring(i+1, i+len+1));
            i += len + 1;
        }
        return list;
    }
}
