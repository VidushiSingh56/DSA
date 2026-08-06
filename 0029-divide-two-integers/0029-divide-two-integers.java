class Solution {
    public int divide(int dividend, int divisor) 
    {
        //divisor
        if(dividend == Integer.MIN_VALUE && divisor == -1)
        return Integer.MAX_VALUE;
        boolean neg = (dividend < 0 ) ^ (divisor < 0);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long quotient=0; 
        while(a >= b)
        {
            int x = findLargestx(a, b);
            a -= b << x;
            quotient += 1<<x;
        }
        if(neg)
        return -(int)quotient;
        return (int)quotient;
    }
    public int findLargestx(long dividend, long divisor)
    {
        int x = 0;
        while(dividend >= divisor<<(x+1))
        x++;

        return x;
    }
}