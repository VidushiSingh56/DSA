import java.util.*;

class Pair{
    int key, value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
class Solution 
{
    public int[] findRedundantConnection(int[][] edges) 
    {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        // need n+1 lists because nodes are 1..n
        for(int i = 0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }    

        for(int i = 1;i<=n;i++)
        {
            adj.get(edges[i-1][0]).add(edges[i-1][1]);
            adj.get(edges[i-1][1]).add(edges[i-1][0]);
        }
        List<Pair> list = new ArrayList<>();
        int parent[] = new int[n+1];
        int visited[] = new int[n+1];
        int ans;
        parent[1] = -1;
        for(int i = 1;i<=n;i++)
        {
            if(visited[i]==0)
            {
                if (dfs(adj, visited, parent, i, list) == 1) {
                    break; // cycle found, no need to continue
                }
            }
        }

        if (list.isEmpty()) return new int[0];

        // reconstruct the full cycle path using parent[]
        int node = list.get(0).getKey();
        int val = list.get(0).getValue();
        int t = val;
        while(node != t)
        {
            int prev = node;
            node = parent[node];
            list.add(new Pair(node, prev));
        }

        for (int i = n - 1; i >= 0; i--) {
            int u = edges[i][0];
            int v = edges[i][1];
            for (Pair p : list) {
                if ((p.getKey() == u && p.getValue() == v) ||
                    (p.getKey() == v && p.getValue() == u)) {
                    return new int[]{u, v};
                }
            }
        }

        return new int[0];

    }

    public int dfs(List<List<Integer>> adj, int[] visited, int[] parent, int node, List<Pair> list)
    {
        visited[node] = 1; // 1 = visiting
        for(int i : adj.get(node))
        {
            // back-edge to an ancestor (not the direct parent) -> cycle found
            if(visited[i] == 1 && parent[node] != i)
            {
                list.add(new Pair(node, i)); // add initial back edge
                return 1;
            }
            if(visited[i] != 0) // already fully visited or currently visiting (handled above)
            {
                continue;
            }
            parent[i] = node;
            if (dfs(adj, visited, parent, i, list) == 1) {
                return 1; // propagate cycle-found signal up the recursion
            }
        }

        visited[node] = 2; // 2 = finished
        return 0;
    }
}
