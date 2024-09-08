class Solution {
    public List<List<String>> solveNQueens(int n) 
    {
        char board[][]=new char[n][n];
        for(int i =0;i<n;i++) //creating a chessboard
        {
            for(int j =0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        solve(0, board, ans);
        return ans;
    }
    public void solve(int col, char[][] board, List<List<String>> ans)
    {
        if(col == board.length)
        {
            ans.add(build(board));
            return;
        }
        

        for(int row = 0;row<board.length;row++)
        {
            if(isSafe(col, row, board))
            {
                board[row][col] = 'Q';
                solve(col+1,  board, ans);
                board[row][col]='.';
            }
        }

    }
    public boolean isSafe(int col, int row, char[][] board)
    {
        int Row = row,Col = col;
        while(col>=0 && row>=0)//upper dia
        {
            if(board[row][col] == 'Q')
            return false;
            row--;
            col--;
        }
        row = Row;
        col = Col;
        while(col>=0 && row<board.length)//lower dia
        {
            if(board[row][col] == 'Q')
            return false;
            row++;
            col--;
        }
        row = Row;
        col = Col;
        while(col>=0)//left
        {
            if(board[row][col] == 'Q')
            return false;
            col--;
        }
        return true;
    }

    public List<String> build(char[][] board)
    {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) 
        {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}