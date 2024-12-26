//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) 
    {

        // Your code here
        int n = adj.size();
        boolean vis[] = new boolean[n];
        boolean path_vis[] = new boolean[n];
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            if(!vis[i])
            dfs(adj, i, vis, path_vis, list);
        }
        Collections.sort(list);
        return list;
    }
    
    boolean dfs(List<List<Integer>> adj, int node, boolean vis[], boolean path_vis[], 
    List<Integer> list)
    
    {
        vis[node] = true;
        path_vis[node] = true;
        
        for(int i : adj.get(node))
        {
            //not visited
            if(!vis[i])
            {
                if(!dfs(adj, i, vis, path_vis, list))
                {
                    // list.add(i);
                    // path_vis[node] = false;
                    return false;
                }
            }
            
            else if(path_vis[i])
            {
                return false;
            }
            
        }
        
        
        
        list.add(node);
        path_vis[node] = false;
        return true;
        
    }
}
