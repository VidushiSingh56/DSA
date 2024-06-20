class Solution 
{
    public int minDays(int[] bloomDay, int m, int k) 
    {
        long mk = (long)m*k;
        if(mk> bloomDay.length)
        {return -1;}
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;

        for(int i=0;i<bloomDay.length;i++)
        {
            mini=Math.min(mini,bloomDay[i]);
            maxi=Math.max(maxi, bloomDay[i]);
        }
        while(mini<=maxi)
        {
            int mid= mini+(maxi-mini)/2;
            if(sayYes(bloomDay, mid, m , k)==true)
            maxi=mid-1;

            else
            mini=mid+1;
        }
        return mini;

        
    }
    public boolean sayYes(int[] bloom, int x, int m, int k)
    {
        int count=0, bouquets=0;
        for(int i=0;i<bloom.length;i++)
        {
            if(bloom[i]<=x)
            {count++;}

            else
            {
                bouquets += count/k;
                count=0;
            }
        }
        bouquets += count/k;
        if(bouquets >= m)
        {
            
            return true;
        }
        

        
        return false;
    }
}