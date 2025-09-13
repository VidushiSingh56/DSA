// import java.util.*;

// class Pair {
//     private final int key;
//     private final int value;

//     public Pair(int key, int value) {
//         this.key = key;
//         this.value = value;
//     }

//     public int getKey() { return key; }
//     public int getValue() { return value; }
// }

// class Solution {
//     public List<Integer> shortestPath(int n, int m, int edges[][]) {
//         List<Integer> ans = new ArrayList<>();
//         if (m == 0) {
//             ans.add(-1);
//             return ans;
//         }

//         // adjacency list
//         List<List<Pair>> adj = new ArrayList<>(n);
//         for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

//         for (int i = 0; i < m; i++) {
//             adj.get(edges[i][0] - 1).add(new Pair(edges[i][1] - 1, edges[i][2]));
//             adj.get(edges[i][1] - 1).add(new Pair(edges[i][0] - 1, edges[i][2]));
//         }

//         int[] explored = new int[n];
//         int[] dis = new int[n];
//         int[] parent = new int[n];
//         Arrays.fill(dis, Integer.MAX_VALUE);
//         Arrays.fill(parent, -1);

//         dis[0] = 0;

//         // Dijkstra O(n^2)
//         for (int i = 0; i < n; i++) {
//             int node = -1, value = Integer.MAX_VALUE;
//             for (int x = 0; x < n; x++) {
//                 if (explored[x] == 0 && dis[x] < value) {
//                     value = dis[x];
//                     node = x;
//                 }
//             }

//             if (node != -1) {
//                 for (Pair j : adj.get(node)) {
//                     int weight = j.getValue();
//                     int child = j.getKey();

//                     if (dis[node] + weight < dis[child]) {
//                         dis[child] = dis[node] + weight;
//                         parent[child] = node;
//                     }
//                 }
//                 explored[node] = 1;
//             }
//         }

//         // No path case
//         if (dis[n - 1] == Integer.MAX_VALUE) {
//             ans.add(-1);
//             return ans;
//         }

//         // reconstruct path
//         int current = n - 1;
//         while (current != -1) {
//             ans.add(current + 1); // back to 1-indexed
//             current = parent[current];
//         }
//         ans.add(dis[n-1]);
//         Collections.reverse(ans);

//         return ans;
//     }
// }
import java.util.*;

class Pair {
    private final int key;
    private final int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() { return key; }
    public int getValue() { return value; }
}

class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<Integer> ans = new ArrayList<>();
        if (m == 0) {
            ans.add(-1);
            return ans;
        }

        // adjacency list
        List<List<Pair>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0] - 1).add(new Pair(edges[i][1] - 1, edges[i][2]));
            adj.get(edges[i][1] - 1).add(new Pair(edges[i][0] - 1, edges[i][2]));
        }

        int vis[] = new int[n];
        int dis[] = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        pq.offer(new Pair(0, 0)); // (distance, node)

        int parent[] = new int[n];
        Arrays.fill(parent, -1);

        while (!pq.isEmpty()) {
            int node = pq.peek().getValue();
            pq.poll();

            if (vis[node] == 1) continue;
            vis[node] = 1;

            for (Pair i : adj.get(node)) {
                int child = i.getKey();
                int weight = i.getValue();

                if (dis[child] > dis[node] + weight) {
                    dis[child] = dis[node] + weight;
                    parent[child] = node;
                    pq.offer(new Pair(dis[child], child)); // (distance, node)
                }
            }
        }

        if (dis[n - 1] == Integer.MAX_VALUE) {
            ans.add(-1);
            return ans;
        }

        int cur = n - 1;
        while (cur != -1) {
            ans.add(cur + 1);
            cur = parent[cur];
        }
        ans.add(dis[n-1]);
        Collections.reverse(ans);
        return ans;
    }
}
