import java.util.*;

class Solution 
{
    
    public int reverse(int x) 
    { 
        long r;
        long rev=0,t=Math.abs(x);
        while(t!=0)
        {
            r=t%10;
            rev=(rev*10)+r;
            t=t/10;

        }
        if(x<0)
        {
            rev=-rev;
        }
        if(rev>= -(Math.pow(2,31)) && rev<= (Math.pow(2,31))-1)
        {
            return (int) rev;
        }
        else{
            return 0;
        }
    }
}