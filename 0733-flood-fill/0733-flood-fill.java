class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        int n = image.length;
        int m = image[0].length;

        int neirow[] = {-1, 0, 1, 0};
        int neicol[] = {0, 1, 0, -1};

        int ans[][] = new int[n][m];
        for(int i =0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                ans[i][j] = image[i][j];
            }
        }
        int cellcolor = image[sr][sc];
        dfs(image, sr, sc, color, neirow, neicol, ans, cellcolor);
        return ans;
    }
    public void dfs(int[][] image, int sr, int sc, int color, int[] neirow, int[] neicol, int[][] ans, int cell)
    {
        ans[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i = 0;i<4;i++)
        {
            int nrow = sr + neirow[i];
            int ncol = sc + neicol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ans[nrow][ncol] != color && image[nrow][ncol] == cell)
            {
                dfs(image, nrow, ncol, color, neirow, neicol, ans, cell);
            }
        }
    }
}