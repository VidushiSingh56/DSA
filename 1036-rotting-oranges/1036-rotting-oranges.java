class Solution {
    public int orangesRotting(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0, count = 0, rotten = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(grid[i][j] == 2)
                q.offer(new int[]{i , j});

                if(grid[i][j] == 1)
                fresh++;
            }
        }
        int rot = q.size();
        if(fresh == 0)
        return 0;

        int dx[] = {-1,0,1,0};
        int dy[] = {0,-1,0,1};
        int cnt = 0;
        int total_min = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            cnt += size; 
           for(int j = 0;j<size;j++)
           {
                int ar[] = q.poll();
            
                int x = ar[0];
                int y = ar[1];

                for(int i = 0;i<4;i++)
                {
                    int xh = x+dx[i];
                    int yh = y+dy[i];
                    if(xh<0 || yh<0 || xh >= m || yh >= n || grid[xh][yh] == 2 || grid[xh][yh] == 0)
                    {
                        continue;
                    }
                    if(grid[xh][yh] == 1)
                    {
                        grid[xh][yh] = 2;
                        q.offer(new int[]{xh,yh});
                    }
                }
           }
           if(!q.isEmpty())
           total_min += 1;
        }
        if(fresh+rot > cnt)
        return -1;

        return total_min;
    }
}