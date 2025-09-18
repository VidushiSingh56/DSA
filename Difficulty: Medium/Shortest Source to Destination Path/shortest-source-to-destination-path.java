// User function Template for Java

class Pair{
    int x, y, steps;
    public Pair(int x, int y, int steps)
    {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
    public int gx()
    {
        return x;
    }
    public int gy()
    {
        return y;
    }
    public int gsteps()
    {
        return steps;
    }
}
class Solution
{
    int shortestDistance(int N, int M, int A[][], int X, int Y) 
    {
        // code here
        
        if(A[0][0] != 1)
        return -1;
        Queue<Pair> queue = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        queue.offer(new Pair(0,0,0));
        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};
        int visited[][] = new int[N][M];
        visited[0][0] = 1;
        while(!queue.isEmpty())
        {
            Pair p = queue.poll();
            int x = p.gx();
            int y = p.gy();
            int steps = p.gsteps();
            
            
            if(x == X && y == Y)
            min = Math.min(min, steps);
            
            
            for(int i = 0;i<4;i++)
            {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx >=0 && xx < N && yy >=0 && yy < M && A[xx][yy] == 1 && visited[xx][yy] == 0)
                {
                    queue.offer(new Pair(xx, yy, steps+1));
                    visited[xx][yy] = 1;
                }
            }
        }
       if(min == Integer.MAX_VALUE)
       return -1;
       
       return min;
    }
};