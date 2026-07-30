class Solution {
    public int totalNQueens(int n) {
        String[][] board = new String[n][n];

        for (String[] row : board) {
            Arrays.fill(row, ".");
        }

        int a[] = new int[1];
        getQueens(0, n, board, a);
        return a[0];
    }

    public void getQueens(int col, int n, String[][] board, int a[]) {
        if (col == n)
        {
            a[0]++;
            return;
        }

        for (int row = 0; row < n; row++) {
            if (canFill(col, row, board, n)) 
            {
                board[row][col] = "Q";

                getQueens(col + 1, n, board, a);

                board[row][col] = ".";
            }
        }
    }

    public boolean canFill(int col, int row, String[][] board, int n) {

        // Check row
        for (int j = 0; j < col; j++) {
            if (board[row][j].equals("Q"))
                return false;
        }

        // // Check column
        // for (int i = 0; i < n; i++) {
        //     if (board[i][col].equals("Q"))
        //         return false;
        // }

        // Upper-left diagonal
        int i = row - 1, j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j].equals("Q"))
                return false;
            i--;
            j--;
        }

        // Lower-right diagonal
        // i = row + 1;
        // j = col + 1;
        // while (i < n && j < n) {
        //     if (board[i][j].equals("Q"))
        //         return false;
        //     i++;
        //     j++;
        // }

        // Upper-right diagonal
        // i = row - 1;
        // j = col + 1;
        // while (i >= 0 && j < n) {
        //     if (board[i][j].equals("Q"))
        //         return false;
        //     i--;
        //     j++;
        // }

        // Lower-left diagonal
        i = row + 1;
        j = col - 1;
        while (i < n && j >= 0) {
            if (board[i][j].equals("Q"))
                return false;
            i++;
            j--;
        }

        return true;
    }
}