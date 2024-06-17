class Solution {
    public boolean judgeSquareSum(int c) 
    {

       long sum;
        int limit=(int)Math.sqrt(c);
        long i=0,j=limit;
        while(i<=j)
        {
            sum=i*i+j*j;
            if(sum<c)
            {
                i++;
            }
            else if(sum>c)
            {
                j--;
            }
            else{
                System.out.print(i+" "+j);
                return true;
            }
        }
        return false;
     
    
}
}