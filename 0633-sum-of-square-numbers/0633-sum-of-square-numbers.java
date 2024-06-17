class Solution {
    public boolean judgeSquareSum(int c) 
    {
        long i=0,j=(int)Math.sqrt(c);
        while(i<=j)
        {
            long x=i*i,y=j*j;
            if(x+y<c)
            {
                i++;
            }
            else if(x+y>c)
            {
                j--;
            }
            else{
                return true;
            }
        }
        return false;
     
    
}
}