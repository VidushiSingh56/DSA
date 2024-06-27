class Solution {
    public List<List<Integer>> generate(int numRows) 
    {
       
        List<List<Integer>> stack = new ArrayList<>();

        
        // if(numRows == 2)
        // {
        //     row.add(1);
        //     row.add(1);
        //     stack.add(row);
        //     return stack;
        // }
        
        for(int i=1;i<=numRows;i++)
        {     List<Integer> row = new ArrayList<>();
            for(int j=1;j<=i;j++)
            {
                int ans= fact(i-1,j-1);
                row.add(ans);
                
            }
            
            stack.add(row);
            
           
        }
        
        return stack;
    }


    public int fact(int i, int j)
    {
        int fact=1;
        for(int x=0;x<j;x++)
        {
            fact =fact*(i-x);
            fact = fact/(x+1);
        }
        return fact;
    }
}