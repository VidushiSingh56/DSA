import java.util.Arrays;

class Solution 
{
    public int orangesRotting(int[][] mat) 
    {
        // Code here
        int n = mat.length;
        int m = mat[0].length;
        int marked[][] = new int[n][m];
        for(int ar[] : marked)
        {
            Arrays.fill(ar, -1);
        }
        int dix[] = {0,-1,1,0};
        int diy[] = {-1,0,0,1};// down, left, right, up
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(mat[i][j] == 2)
                {
                    queue.offer(new int[]{i,j});
                }
            }
            
        }
        int count = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
            int flag = 0;
            for(int i = 0;i<size;i++)
            {
                int node[] = queue.poll();
                for(int j=0;j<4;j++)
                {
                    int dx = node[0]+dix[j];
                    int dy = node[1]+diy[j];
                    
                    if(dx>=0 && dx<n && dy>=0 && dy<m && mat[dx][dy] == 1)
                    {
                        flag = 1;
                        mat[dx][dy] = 2;
                        queue.offer(new int[]{dx,dy});
                        
                    }
                }
            }
            if(flag == 1)
            count++;
        }
        
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(mat[i][j] == 1)
                {
                    return -1;
                }
            }
        }
        return count;
        
    }
    
}