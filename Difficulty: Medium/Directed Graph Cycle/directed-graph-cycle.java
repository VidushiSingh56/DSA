class Solution {
    public boolean isCyclic(int V, int[][] edges) 
    {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[V];
        
        
        for(int i =  0 ;i<V;i++)
        {
            for(int j : adj.get(i))
            {
                indegree[j]++;
            }
        }
        
        for(int i = 0;i<V;i++)
        {
            if(indegree[i] == 0)
            q.offer(i);
        }
        while(!q.isEmpty())
        {
            int node = q.poll();
            ans.add(node);
            for(int i : adj.get(node))
            {
                indegree[i] --;
                if(indegree[i] == 0)
                {
                    q.offer(i);
                    continue;
                }
            }
        }
        
        if(ans.size() == V)
        return false;
        
        return true;
    }
}