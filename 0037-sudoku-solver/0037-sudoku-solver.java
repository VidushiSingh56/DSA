class Solution 
{
    public void solveSudoku(char[][] board) 
    {
        boolean b = solvesudoku(board);
    }

    public boolean solvesudoku(char[][] board)
    {
        for(int i = 0;i<9;i++)
        {
            for(int j = 0;j<9;j++)
            {
                if(board[i][j] == '.')
                {
                    for(char c = '1'; c <= '9';c++)
                    {
                        if(isValid(i,j,c,board))
                        {
                            board[i][j] = c;

                            if(solvesudoku(board))
                            return true;
                            else
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }
    public boolean isValid(int row, int col, char c, char[][] board)
    {
        for(int i = 0;i<9;i++)
        {
            if(board[row][i] == c)
            return false;

            if(board[i][col] == c)
            return false;
        }
        int i = row - (row%3), j = col - (col%3), n = i+3, m = j+3;
        for(int x = i; x < n; x++)
        {
            for(int y = j;y<m;y++)
            {
                if(board[x][y] == c)
                return false;
            }
        }

        return true;
    }
}