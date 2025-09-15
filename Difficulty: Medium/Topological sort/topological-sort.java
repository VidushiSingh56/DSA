class Solution 
{
    public static ArrayList<Integer> topoSort(int V, int[][] edges) 
    {
        // code here
        
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int visited[] =  new int[V];
        for(int i = 0;i<V;i++)
        {
            if(visited[i] == 0)
            dfs(stack, visited, adj, i);
        }
        
        while(!stack.isEmpty())
        {
            ans.add(stack.pop());
        }
        return ans;
    }
    
    public static void dfs(Stack<Integer> stack, int[] visited, List<List<Integer>> adj, int node)
    {
        if(visited[node]==1)
        return;
        
        visited[node] = 1;
        for(int j : adj.get(node))
        {
            dfs(stack, visited, adj, j);
        }
        stack.push(node);
    }
}