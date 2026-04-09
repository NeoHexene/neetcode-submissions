class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int edge[] : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, -1});
        visited.add(0);
        while(!q.isEmpty()) {
            int curr[] = q.poll();
            int node = curr[0], parent = curr[1];
            for (Integer nei : map.get(node)) {
                if (nei == parent) {
                    continue;
                }
                if (visited.contains(nei)) {
                    return false;
                }
                visited.add(nei);
                q.offer(new int[]{nei, node});
            }
        }
        return visited.size() == n;
    }
}
