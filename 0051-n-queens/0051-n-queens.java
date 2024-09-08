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
        int left[]=new int[n];
        int lowerdia[]=new int[2*n-1];
        int upperdia[]=new int[2*n-1];
        List<List<String>> ans = new ArrayList<>();
        solve(0, board, ans,left, lowerdia, upperdia );
        return ans;
    }
    public void solve(int col, char[][] board, List<List<String>> ans, int left[], int lowerdia[], int upperdia[])
    {
        if(col == board.length)
        {
            ans.add(build(board));
            return;
        }
        

        for(int row = 0;row<board.length;row++)
        {
            if(left[row] == 0 && lowerdia[row + col] == 0 && upperdia[board.length - 1 + col - row] == 0)
            {
                board[row][col] = 'Q';
                left[row] = 1;
                lowerdia[row + col] = 1;
                upperdia[board.length - 1 + col - row] = 1;
                solve(col+1,  board, ans, left, lowerdia, upperdia);
                board[row][col]='.';
                left[row] = 0;
                lowerdia[row + col] = 0;
                upperdia[board.length - 1 + col - row] = 0;
            }
        }

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