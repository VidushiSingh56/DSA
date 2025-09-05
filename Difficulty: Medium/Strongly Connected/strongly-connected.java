import java.util.*;
class Solution 
{
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) 
    {
        // code here
        
        //1.write it in toposort and then put inside a stack;
        //2.reverse
        //3.write dfs of this in the stack order and keep counting scc
        
        //kosaraju algorithm
        //put topo elements in stack
        int n = adj.size();
        Stack<Integer> stack = new Stack<>();
        int vis[] = new int[n];
        
        for(int i=0;i<n;i++)
        {
            if(vis[i] != 1)
            dfs(adj, vis, i, stack);
        }
        
        //now reverse
        List<List<Integer>> adj2 = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj2.add(new ArrayList<>());
        }
        
        for(int i = 0;i<n;i++)
        {
            for(int j : adj.get(i))
            {
                adj2.get(j).add(i);
            }
        }
        
        //dfs 
        for(int i=0;i<n;i++)
        {
            Arrays.fill(vis, 0);
        }
        int scc=0;
        while(!stack.isEmpty())
        {
            int node = stack.pop();
            if(vis[node] != 1)
            {
                dfs2(adj2, vis, node);
                scc++;
            }
        }
        return scc;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node, Stack<Integer> stack)
    {
        vis[node] = 1;
        for(int j : adj.get(node))
        {
            if(vis[j] != 1)
            {
                dfs(adj, vis, j,stack);
            }
        }
        stack.push(node);
    }
    
    public void dfs2(List<List<Integer>> adj2, int[] vis, int node)
    {
        vis[node] = 1;
        for(int j : adj2.get(node))
        {
            if(vis[j] != 1)
            {
                dfs2(adj2, vis, j);
            }
        }
    }
}