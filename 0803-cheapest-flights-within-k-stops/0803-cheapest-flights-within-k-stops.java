import java.util.*;

class Pair {
    int to, w;
    Pair(int to, int w) { this.to = to; this.w = w; }
}

class Triple {
    int cost, node, edges; // edges = number of edges used to reach `node`
    Triple(int cost, int node, int edges) {
        this.cost = cost; this.node = node; this.edges = edges;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] f : flights) adj.get(f[0]).add(new Pair(f[1], f[2]));

        int maxEdges = k + 1; // with k stops you can take at most k+1 edges
        // best[node][e] = min cost to reach node using exactly e edges (0..maxEdges)
        int[][] best = new int[n][maxEdges + 1];
        for (int i = 0; i < n; i++) Arrays.fill(best[i], Integer.MAX_VALUE);

        // start at src with 0 cost and 0 edges used
        best[src][0] = 0;
        PriorityQueue<Triple> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.cost));
        pq.offer(new Triple(0, src, 0));

        while (!pq.isEmpty()) {
            Triple cur = pq.poll();
            int cost = cur.cost, node = cur.node, edges = cur.edges;

            // If we've used more edges than allowed, skip
            if (edges > maxEdges) continue;

            // If we popped a node with cost greater than the best recorded for this (node,edges), skip
            if (cost > best[node][edges]) continue;

            // If this is destination and within allowed edges, return cost
            if (node == dst) return cost;

            // Relax neighbors (increment edge count)
            for (Pair p : adj.get(node)) {
                int nei = p.to;
                int w = p.w;
                int nextEdges = edges + 1;
                if (nextEdges > maxEdges) continue; // would exceed allowed edges

                int newCost = cost + w;
                if (newCost < best[nei][nextEdges]) {
                    best[nei][nextEdges] = newCost;
                    pq.offer(new Triple(newCost, nei, nextEdges));
                }
            }
        }

        return -1; // no valid route
    }
}
