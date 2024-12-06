class Solution {
    public int[][] updateMatrix(int[][] mat) 
    {
        int m = mat.length;
        int n = mat[0].length;
        int ans[][] = new int[m][n];
        boolean vis[][] = new boolean[m][n];

        Queue <int[]> q = new LinkedList<>();
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(mat[i][j] == 0)
                q.offer(new int[]{i,j});
            }
        }
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        int factor = 0;
        int size = q.size();
        
            while(!q.isEmpty())
            {
                size = q.size();
                for(int j = 0;j<size;j++)
                {
                int ar[] = q.poll();
                int x = ar[0];
                int y = ar[1];
            
                if(vis[x][y])
                continue;

                vis[x][y] = true;
                ans[x][y] = factor;

                for(int i = 0;i<4;i++)
                {
                    int xh = x + dx[i];
                    int yh = y + dy[i];

                    if(xh >= m || yh >= n || xh < 0 || yh < 0 || mat[xh][yh] == 0)
                    continue;

                    q.offer(new int[]{xh,yh});
                }
                }
                factor++;
                
            }
        return ans;
    }
}