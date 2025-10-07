class Triple{
    int node, row, col;
    public Triple(int node, int row, int col)
    {
        this.node = node;
        this.row = row;
        this.col = col;
    }
    public int getnode()
    {
        return node;
    }
    public int getrow()
    {
        return row;
    }
    public int getcol()
    {
        return col;
    }
}
class Solution 
{
    public int swimInWater(int[][] grid) 
    {
        int n = grid.length;
        PriorityQueue<Triple> pq = new PriorityQueue<>((a, b) -> a.node - b.node);
        boolean[][] visited = new boolean[n][n];

        pq.offer(new Triple(grid[0][0], 0, 0));
        // visited[0][0] = true;

        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,1,-1};
        int time = 0;
        
        while(!pq.isEmpty())
        {
            Triple t = pq.poll();
            int r = t.getrow();
            int c = t.getcol();
            int minimum_time = t.getnode();

            time = Math.max(time, minimum_time);


            if(r == n-1 && c==n-1)
            return time;

            if (visited[r][c]) continue;
            visited[r][c] = true;

            for(int i =0;i<4;i++)
            {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >=0 && nc >=0 && nr <n && nc < n && visited[nr][nc] == false)
                {
                    pq.offer(new Triple(grid[nr][nc], nr, nc));
                }

            }

            
        }
        return time;
    }
}
