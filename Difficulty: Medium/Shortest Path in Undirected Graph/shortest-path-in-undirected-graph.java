import java.util.Arrays;
class Solution 
{
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) 
    {
        // code here
        int n = adj.size();
        
        
        
        int dis[] = new int[n];
        Arrays.fill(dis, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        dis[src] = 0;
        
        queue.offer(src);
        while(!queue.isEmpty())
        {
            
            int node = queue.poll();
            
            
            for(int j : adj.get(node))
            {
                if(dis[j] == -1)
                {
                    dis[j] = dis[node] + 1;
                    queue.offer(j);
                }
                
            }
        }
        
        return dis;
    }
}
