class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        int m = image.length;
        int n= image[0].length;

        int ar[][] = new int[m][n];

        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                ar[i][j] = image[i][j];
            }
        }

        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,1,-1};

        dfs(image, sr, sc, color, dx, dy, m, n, ar);
        return ar;

    }
    public void dfs(int[][] image, int sr, int sc, int color, int dx[], int dy[], int m, int n, int ar[][])
    {
        ar[sr][sc] = color;
        for(int i = 0;i<4;i++)
        {
            int x = sr+dx[i];
            int y = sc+dy[i];
            if(x>=0 && x<m && y>=0 && y<n && image[x][y] == image[sr][sc] && ar[x][y] != color)
            {
                dfs(image, x, y, color, dx, dy, m, n, ar);
            }
        }
    }
}