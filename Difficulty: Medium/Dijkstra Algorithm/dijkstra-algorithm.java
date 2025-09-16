import java.util.*;
class Pair{
    int key, value;
    
    public Pair(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
    
    public int getKey()
    {return key;}
    
    public int getValue()
    {return value;}
}
class Solution 
{
    public int[] dijkstra(int V, int[][] edges, int src) 
    {
        // code here
        
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        
        int dis[] = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        int visited[] = new int[V];
        
        dis[src] = 0;
        
        pq.offer(new Pair(0, src));
        
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int node = p.getValue();
            // int distance = pq.peek().getKey();
           
            
            for(Pair nei : adj.get(node))
            {
                int nei_node = nei.getKey();
                int weight = nei.getValue();
                
                if(visited[nei_node] == 1)
                continue;
                
                if(dis[nei_node] > dis[node]+weight)
                {
                    dis[nei_node] = dis[node]+weight;
                    pq.offer(new Pair(dis[nei_node], nei_node));
                }
            }
            
            visited[node] = 1;
        }
        
        return dis;
        
        
        
    }
}