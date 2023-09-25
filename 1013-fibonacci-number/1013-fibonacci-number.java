class Solution {
    public int fib(int n) 
   {
        
        if(n==0)
        {
           return 0;
        }
        else if(n==1)
        {
           return 1;
        }
        else{
             
            int ar[]=new int[n+1];
            ar[0]=0;ar[1]=1;
            int k=2;
            int res= fibo(ar,k,n );
            return res;
            
            }
        

    }

    public int fibo(int ar[], int k, int n)

    {
        if (k>n) 
        {
            return ar[k-1];
        }
        ar[k] = ar[k - 1] + ar[k-2];
        return fibo(ar, k + 1, n);
    }
}