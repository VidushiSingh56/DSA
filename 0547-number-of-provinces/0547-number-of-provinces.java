class Solution {
    public int findCircleNum(int[][] isConnected) 
    {
        int n = isConnected.length;
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        //List<Integer> ar = new ArrayList<>();

        q.add(0);
        vis[0] = true;
        int count = 1;
        for(int i = 0;i<n;i++)
        {
            if(!vis[i])
            {
                count++;
                q.add(i);
                vis[i] = true;
            }

            while(!q.isEmpty())
            {
                int node = q.poll();
            //ar.add(node);

            for(int j = 0;j<n;j++)
            {
                if(isConnected[node][j] == 1 && vis[j] == false)
                {
                    vis[j] = true;
                    if(node != j)
                    q.add(j);
                }

            }
            }
        }
        return count;
    }
}