// class Pair {
//     int node, weight;
//     public Pair(int node, int weight) {
//         this.node = node;
//         this.weight = weight;
//     }
//     public int getNode() {
//         return node;
//     }
//     public int getWeight() {
//         return weight;
//     }
// }

// class Solution {
//     public int spanningTree(int V, int[][] edges) {
//         // Build adjacency list
//         List<List<Pair>> adj = new ArrayList<>();
//         for (int i = 0; i < V; i++) {
//             adj.add(new ArrayList<>());
//         }
//         for (int i = 0; i < edges.length; i++) {
//             int u = edges[i][0];
//             int v = edges[i][1];
//             int wt = edges[i][2];
//             adj.get(u).add(new Pair(v, wt));
//             adj.get(v).add(new Pair(u, wt));
//         }

//         // Min-heap: (weight, node)
//         PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getWeight));
//         boolean[] visited = new boolean[V];

//         pq.offer(new Pair(0, 0)); // start with node 0 and weight 0
//         int minCost = 0;

//         while (!pq.isEmpty()) {
//             Pair p = pq.poll();
//             int node = p.getNode();
//             int weight = p.getWeight();

//             if (visited[node]) continue;

//             // Add this edge to MST
//             minCost += weight;
//             visited[node] = true;

//             // offer neighbors
//             for (Pair neighbor : adj.get(node)) {
//                 if (!visited[neighbor.getNode()]) {
//                     pq.offer(new Pair(neighbor.getNode(), neighbor.getWeight()));
//                 }
//             }
//         }
//         return minCost;
//     }
// }

class Edge
{
    int u,v,wt;
    public Edge(int u, int v, int wt)
    {
        this.u=u;
        this.v=v;
        this.wt=wt;
    }
    public int getwt()
    {
        return wt;
    }
    public int getU()
    {
        return u;
    }
    public int getV()
    {
        return v;
    }
};
class Pair
{
    int v,wt;
    public Pair(int v, int wt)
    {
        
        this.v=v;
        this.wt=wt;
    }
    public int getwt()
    {
        return wt;
    }
    public int getVer()
    {
        return v;
    }
};

class Solution 
{
    public int spanningTree(int V, int[][] edges) 
    {
        
        
    //Kruskal's algorithm
    //find ultimate parent of u->v
    //if ultimate parent is same then its in one set and hence no edge counting
    //if ultimate parent is not same its in different set and hence count that edge

        List<List<Pair>> adj =  new ArrayList<>();
        for(int i = 0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
    
        int parent[] = new int[V];//to determine set
        int rank[] = new int[V];//to determine merging
            
        for(int i =0;i<V;i++)
        {
            parent[i]=i;
        }
        
    
        //priority queue
        //wt,u,v
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getwt));
        for(int i = 0;i<V;i++)
        {
            for(Pair j : adj.get(i))
            {
                pq.offer(new Edge(i, j.getVer(), j.getwt()));
          
            }
        }
        
        int cost = 0, edge=0;
        while(!pq.isEmpty())
        {
            Edge e = pq.poll();
            int u = e.getU();
            int v = e.getV();
            int wt = e.getwt();
            
            //check if they are in diff set
            if(findUltimateParent(u, parent) != findUltimateParent(v, parent))
            {
                cost += wt;
                unionbyrank(rank, parent, u, v);
                edge++;
            }
            
            if(edge == V-1)
            break;
        }
        
        
        return cost;
    }
    
    
    
    
    public void unionbyrank(int rank[], int parent[], int u, int v)
    {
        int pu = findUltimateParent(u, parent);
        int pv = findUltimateParent(v, parent);
        
        if(rank[pu] > rank[pv])
        {
            parent[pv] = pu;
        }
        else if(rank[pu] < rank[pv])
        {
            parent[pu] = pv;
        }
        else
        {
            parent[pv] = pu;
            rank[pu]++;
        }
        
    }
    public int findUltimateParent(int u, int[] parent)
    {
        if(u == parent[u])
        return u;
        
        parent[u] = findUltimateParent(parent[u], parent);
        return parent[u];
    }
    
}