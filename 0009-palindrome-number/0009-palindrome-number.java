
class Solution 
{
    public boolean isPalindrome(int x) 
    {
       
       int t=Math.abs(x),r,rev=0;
       while(t!=0)
       {
           r=t%10;
           rev=rev*10+r;
           t=t/10;
       }
       if(x<0)
       {
           return false;
       }
       else{
           if(rev==x)
           {
               return true;
           }
           else{
               return false;
           }
       }
    }
}