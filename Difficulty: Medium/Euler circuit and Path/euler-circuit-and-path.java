class Solution {
    public int isEulerCircuit(int V, List<Integer>[] adj) {
        // Step 1: check connectivity (ignoring isolated vertices)
        if (!isConnected(V, adj)) {
            return 0;
        }

        // Step 2: count vertices with odd degree
        int oddCount = 0;
        for (int i = 0; i < V; i++) {
            if (adj[i].size() % 2 != 0) {
                oddCount++;
            }
        }

        // Step 3: classify result
        if (oddCount == 0) {
            return 2; // Eulerian Circuit
        } else if (oddCount == 2) {
            return 1; // Eulerian Path (but not circuit)
        } else {
            return 0; // Neither
        }
    }

    private boolean isConnected(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];

        // find first vertex with non-zero degree
        int start = -1;
        for (int i = 0; i < V; i++) {
            if (!adj[i].isEmpty()) {
                start = i;
                break;
            }
        }

        // if no edges, graph is trivially Eulerian
        if (start == -1) return true;

        // run DFS from first non-isolated node
        dfs(start, visited, adj);

        // check if all non-isolated vertices are visited
        for (int i = 0; i < V; i++) {
            if (!visited[i] && !adj[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int node, boolean[] visited, List<Integer>[] adj) {
        visited[node] = true;
        for (int nei : adj[node]) {
            if (!visited[nei]) {
                dfs(nei, visited, adj);
            }
        }
    }
}
                