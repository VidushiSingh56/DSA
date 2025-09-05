class Solution 
{
    public int countIslands(char[][] grid) 
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        // for(int ar[] : vis)
        // Arrays.fill(ar, -1)
        
        int dx[] = {-1,0,1,0,-1,1,1,-1};
        int dy[] = {0,1,0,-1,1,1,-1,-1};
        
        int count = 0;
        for(int i = 0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                if(grid[i][j] == 'L' && vis[i][j] != 1)
                {
                    count++;
                    dfs(vis, grid, i, j, dx, dy, n,m);
                }
            }
        }
        return count;
    }
    
    public void dfs(int[][] vis, char[][] grid, int i, int j, int[] dx, int[] dy, int n, int m)
    {
        vis[i][j] = 1;
        for(int x=0;x<8;x++)
        {
            int posx = i + dx[x];
            int posy = j + dy[x];
            if(posx>=0 && posx<n && posy>=0 && posy<m && vis[posx][posy] == 0 && grid[posx][posy] == 'L')
            {
                dfs(vis, grid, posx, posy, dx, dy, n, m);
            }
        }
    }
}