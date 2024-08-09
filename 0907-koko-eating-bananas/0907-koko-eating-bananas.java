class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {
        
        
        
       

       
        int n=piles.length;
     
        int temp=0;
         int min=1, max = findmax(piles);
        while(min<=max)
        {
            int mid=(min+max)/2;
             System.out.println(mid);
             long totalhrs =func(piles, h, mid);
            if(totalhrs <= h)
            {
                temp=mid;
                max=mid-1;
            }
            else
            {
                min=mid+1;
            }
        }
        return temp;

        
    }
    public int findmax(int piles[])
    {
        int n=piles.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(max<piles[i])
            {
                max=piles[i];
            }
        }
        return max; 
    }
    public long func(int piles[],int h,int g)
    {
        long hrs=0;
        for(int i=0;i<piles.length;i++)
        {
            double hr=(double)piles[i]/g;
            hrs += (long)Math.ceil(hr);
        }
        //  System.out.println(g);
        // System.out.println(hrs);
        return hrs;
    }
}