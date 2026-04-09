class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] count = new List[nums.length + 1];
        for (int i = 0; i < count.length; i++) {
            count[i] = new ArrayList<>();
        }
        for (Integer key : freq.keySet()) {
            count[freq.get(key)].add(key);
        }
        int[] res = new int[k];
        int j = 0;
        for (int i = count.length - 1; j < k && i >= 0; i--) {
            if (!count[i].isEmpty()) {
                for (int x = 0; x < count[i].size() && j < k; x++) {
                    res[j] = count[i].get(x);
                    j++;
                }
            }
        }
        return res;
    }
}
