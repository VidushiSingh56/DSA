class Solution 
{
    public int minimumArea(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        int max_i = 0, min_i = n, max_j = 0, min_j = m;
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j] == 1)
                {
                    max_j = Math.max(max_j, j);
                    min_j = Math.min(min_j, j);
                    max_i = Math.max(max_i, i);
                    min_i = Math.min(min_i, i);
                }
            }
        }
        return (max_j - min_j + 1) * (max_i - min_i + 1);
        
    }
}