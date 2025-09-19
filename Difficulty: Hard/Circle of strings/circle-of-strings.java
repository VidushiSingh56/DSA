// User function Template for Java

class Solution 
{
    public int isCircle(String arr[]) 
    {
        // code here
        int n = arr.length;
        int indegree[] = new int[26];
        int outdegree[] = new int[26];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i<26;i++)
        {
            list.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++)
        {
            int len = arr[i].length();
            char s = arr[i].charAt(0);
            char e = arr[i].charAt(len-1);
            
            indegree[s-'a']++;
            outdegree[e-'a']++;
            
            list.get(s-'a').add(e-'a');
        }
        
        int flag = 0;
        for(int i = 0;i<26;i++)
        {
            if(indegree[i] != outdegree[i])
            {
                flag++;
                break;
            }
        }
        
        if(flag == 1)
        return 0;
        
        int visited[] = new int[26];
        int start = -1;
        for(int i = 0;i<26;i++)
        {
            if(!list.get(i).isEmpty())
            {
                start = i;
                break;
            }
        }
        dfs(start, list, visited);
        
        for(int i=0;i<26;i++)
        {
            if(!list.get(i).isEmpty() && visited[i] == 0)
            {
                return 0;
            }
        }
        
        return 1;
    }
    public void dfs(int node, List<List<Integer>> list, int[] visited)
    {
        visited[node] = 1;
        for(int i : list.get(node))
        {
            if(visited[i] == 0)
            dfs(i, list, visited);
        }
    }
}