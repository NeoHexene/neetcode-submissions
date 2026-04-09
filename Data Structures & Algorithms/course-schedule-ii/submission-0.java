class Solution {

    private List<Integer> ans = new ArrayList<>();
    private Set<Integer> visited = new HashSet<>();
    private Set<Integer> cycle = new HashSet<>();
    private Map<Integer, List<Integer>> map = new HashMap<>();
    
    public int[] findOrder(int courses, int[][] prerequisites) {
        for (int c = 0; c < courses; c++) {
            map.put(c, new ArrayList<>());
        }
        for (int curr[] : prerequisites) {
            map.get(curr[0]).add(curr[1]);
        }
        for (int c = 0; c < courses; c++) {
            if (!dfs(c)) {
                return new int[]{};
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private boolean dfs(int c) {
        if (cycle.contains(c)) {
            return false;
        }
        if (visited.contains(c)) {
            return true;
        }
        cycle.add(c);
        for (Integer child : map.get(c)) {
            if (!dfs(child)) {
                return false;
            }
        }
        ans.add(c);
        visited.add(c);
        cycle.remove(c);
        return true;
    }
}
