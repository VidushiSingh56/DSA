class Solution {
    public boolean exist(char[][] board, String word) 
    {
        int x=0;
        int m=board.length;
        int n=board[0].length;
        boolean visited[][]= new boolean[m][n];
        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {                                                        //0,1,1
                visited[i][j]=false;
            }
        }
        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {                                                        //0,1,1
                if(board[i][j]==word.charAt(0))
                {
                    System.out.print(i+""+j+" ");

                    visited[i][j]=true;
                    boolean h = check(board, word, i, j, x+1, visited);
                    if(h)return true;
                    else visited[i][j] = false;
                }
            }
        }  
        System.out.println("heloo");
        return false;
    }
    public boolean check(char[][] board, String word, int i, int j, int x,boolean visited[][])
    {
        int m = board.length;
        int n = board[0].length;
        if(x == word.length())
        return true;
        boolean what = false;

        if(i>0 && board[i-1][j]==word.charAt(x) && visited[i-1][j]==false)//up
        {
            visited[i-1][j] = true;
            what = check(board, word, i-1, j, x+1, visited);
            if(what)return true;
            visited[i-1][j]=false;
        }
        if(j<n-1 && board[i][j+1]==word.charAt(x) && visited[i][j+1]==false)// right
        {
            visited[i][j+1] = true;
            what = check(board, word, i, j+1, x+1, visited);
             if(what)return true;
            visited[i][j+1]=false;
        }
        if(j>0 && board[i][j-1] == word.charAt(x) && visited[i][j-1]==false)//left
        {
            visited[i][j-1] = true;
            what = check(board, word, i, j-1, x+1, visited);
             if(what)return true;
            visited[i][j-1]=false;
        }
        if(i<m-1 && board[i+1][j]==word.charAt(x) && visited[i+1][j] == false)//bottom
        {
            visited[i+1][j]=true;
            what = check(board, word, i+1, j, x+1, visited);
             if(what)return true;
            visited[i+1][j]=false;
        }
        // if(what == false)
        // {

        // }
    return false;
    }
}