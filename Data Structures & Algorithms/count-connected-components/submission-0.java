class Solution {
    private Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int curr[] : edges) {
            adj.get(curr[0]).add(curr[1]);
            adj.get(curr[1]).add(curr[0]);
        }
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            components += 1;
            bfs(i, adj);
        }
        return components;
    }

    private void bfs(int node, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (Integer nei : adj.get(curr)) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    q.offer(nei);
                }
            }
        }
        visited.add(node);
        return;
    }
}
