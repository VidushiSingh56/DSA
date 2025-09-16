import java.util.*;

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        // Relax edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            boolean updated = false;
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (dis[u] != Integer.MAX_VALUE && dis[v] > dis[u] + w) {
                    dis[v] = dis[u] + w;
                    updated = true;
                }
            }
            if (!updated) break; // no update → stop early
        }

        // Check for negative weight cycle
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (dis[u] != Integer.MAX_VALUE && dis[v] > dis[u] + w) {
                return new int[]{-1};
            }
        }
        for (int i = 0; i < V; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                dis[i] = 100000000;
            }
        }

        return dis;
    }
}
