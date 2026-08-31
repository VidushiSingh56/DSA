class Solution 
{
    public String decodeCiphertext(String encodedText, int row) 
    {
        int length = encodedText.length();
        int col = length/row;
        char ar[][] = new char[row][col];
        
        int x = 0, y = 0;
        for(int i = 0; i<length; i++)
        {
            char ch = encodedText.charAt(i);
            if(i!=0 && i % col == 0)
            {
                x++;
                y=0;
            }

            ar[x][y] = ch;
            // System.out.print(ar[x][y]);
            // System.out.print(x + "" + y);
            // System.out.println();
            y++;
        }

        StringBuilder s = new StringBuilder();
        y = 0;

        for(x = 0; x < col; x++)
        {
            int j = y;
            for(int i = 0; i<row;i++)
            {
                
                if(j>=col)break;

                s.append(ar[i][j]);
                j++;
            }
            y++;
        }

        return s.toString().stripTrailing();
    }
}