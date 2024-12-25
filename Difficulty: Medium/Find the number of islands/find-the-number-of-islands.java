//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Pair
{
    int u, v;
    
    public Pair(int u, int v)
    {
        this.u = u;
        this.v = v;
    }
}

class Solution 
{
    public int numIslands(char[][] grid) 
    {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        int count = 0;
        
        int dx[] = {1,1,-1,-1,0,0,-1,1};
        int dy[] = {0,-1,1,0,1,-1,-1,1};
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(!vis[i][j] && grid[i][j] == '1')
                {
                    bfs(grid, vis, i, j, dx, dy);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void bfs(char[][] grid, boolean vis[][], int row, int col, int[] dx, int[] dy)
    {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        vis[row][col] = true;
        q.offer(new Pair(row, col));
        
        while(!q.isEmpty())
        {
            int size = q.size();
           for(int a = 0;a<size;a++)
           {
                Pair d = q.poll();
                int x = d.u;
                int y = d.v;
                for(int i = 0;i<8;i++)
                {
                    int r = x+dx[i];
                    int c = y+dy[i];
                    
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c] == '1' && !vis[r][c])
                    {
                        vis[r][c] = true;
                        q.offer(new Pair(r,c));
                    }
                }
           }
            
        }
    }
}