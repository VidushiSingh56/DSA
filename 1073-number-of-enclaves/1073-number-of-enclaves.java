class Solution 
{
    public int numEnclaves(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        int dx[] = {-1,0,0,1};
        int dy[] = {0,-1,1,0};
        // int ans[][] = new int[m][n];
        // for(int i = 0;i<m;i++)
        // {
        //     for(int j = 0;j<n;j++)
        //     {
        //         ans[i][j] = grid[i][j];
        //     }
        // }
        for(int j = 0;j<n;j++)
        {
            //first row
            if(!vis[0][j] && grid[0][j] == 1)
            dfs(grid, 0, j, vis, m, n, dx, dy);

            //last row
            if(!vis[m-1][j] && grid[m-1][j] == 1)
            dfs(grid, m-1, j, vis,m, n, dx, dy);
        }

        for(int i = 0;i<m;i++)
        {
            //first col
            if(!vis[i][0] && grid[i][0] == 1)
            dfs(grid, i, 0, vis,m, n, dx, dy);

            //last col
            if(!vis[i][n-1] && grid[i][n-1] == 1)
            dfs(grid, i, n-1, vis, m, n, dx, dy);
        }
        int count = 0;
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(!vis[i][j] && grid[i][j] == 1)
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int row, int col, boolean[][] vis, int m, int n, int[] dx, int[] dy)
    {
        vis[row][col] = true;
        for(int i = 0;i<4;i++)
        {
            int nrow = row + dx[i];
            int ncol = col + dy[i];

            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && !vis[nrow][ncol] && grid[nrow][ncol]==1)
            {
                dfs(grid, nrow, ncol, vis, m, n, dx, dy);
            }
        }
    }
}