class Pair {
    int node, weight;
    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
    public int getNode() {
        return node;
    }
    public int getWeight() {
        return weight;
    }
}

class Solution {
    public int spanningTree(int V, int[][] edges) {
        // Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        // Min-heap: (weight, node)
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getWeight));
        boolean[] visited = new boolean[V];

        pq.offer(new Pair(0, 0)); // start with node 0 and weight 0
        int minCost = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.getNode();
            int weight = p.getWeight();

            if (visited[node]) continue;

            // Add this edge to MST
            minCost += weight;
            visited[node] = true;

            // Push neighbors
            for (Pair neighbor : adj.get(node)) {
                if (!visited[neighbor.getNode()]) {
                    pq.offer(new Pair(neighbor.getNode(), neighbor.getWeight()));
                }
            }
        }
        return minCost;
    }
}
