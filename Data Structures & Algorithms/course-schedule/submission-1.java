class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int c = 0; c < numCourses; c++) {
            map.put(c, new ArrayList<>());
        }
        for (int curr[] : prerequisites) {
            map.get(curr[0]).add(curr[1]);
        }
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) return false;
        }
        return true;
    }

    private boolean dfs(int c) {
        if (visited.contains(c)) { // cycle detected
            return false;
        }
        if (map.get(c).isEmpty()) { // no prerequisites
            return true;
        }
        visited.add(c);
        for (int pre : map.get(c)) {
            if (!dfs(pre)) return false;
        }
        visited.remove(c);
        map.put(c, new ArrayList<>());
        return true;
    }
}
