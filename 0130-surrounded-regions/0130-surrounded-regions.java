class Solution 
{
    public void solve(char[][] board) 
    {
        int m = board.length;
        int n = board[0].length;
        boolean vis[][] = new boolean[m][n];
        

        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,1,-1};
        //frist and last row
        for(int i = 0;i<n;i++)
        {
            //first row
            if(board[0][i]=='O' && !vis[0][i])
            dfs(vis, board, dx, dy, 0, i);

            if(board[m-1][i] == 'O' && !vis[m-1][i])
            dfs(vis, board, dx, dy, m-1, i);
        }
        for(int i = 0;i<m;i++)
        {
            //first col
            if(board[i][0]=='O' && !vis[i][0])
            dfs(vis, board, dx, dy, i, 0);

            if(board[i][n-1] == 'O' && !vis[i][n-1])
            dfs(vis, board, dx, dy, i, n-1);
        }
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(!vis[i][j] && board[i][j] == 'O')
                board[i][j] = 'X';
            }
        }

    }
    public void dfs(boolean[][] vis, char[][] board, int dx[], int dy[], int row, int col)
    {
        int m = board.length;
        int n = board[0].length;
        vis[row][col] = true;
        for(int i = 0;i<4;i++)
        {
            int x = row + dx[i];
            int y = col + dy[i];
            if(x>=0 && y>=0 && x<m && y<n && board[x][y] == 'O' && !vis[x][y])
            {
                dfs(vis, board, dx, dy, x, y);
            }
        }
    }
}