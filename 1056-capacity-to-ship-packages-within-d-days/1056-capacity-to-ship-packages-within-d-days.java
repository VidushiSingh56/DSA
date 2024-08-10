class Solution {
    public int shipWithinDays(int[] weights, int days)
    {
        int greatest=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<weights.length;i++)
        {
            sum += weights[i];
            if(greatest < weights[i])
            {
                greatest = weights[i];
            }
            
        }
        
        int min=greatest, max=sum;
        int rem=0;
        while(min<=max)
        {
            int mid=(min+max)/2;
            int ans=func(weights, mid);
            
            if(ans <= days)
            {
                rem = mid;
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }
        return rem;
        
    }
    public int func(int weights[], int mid)
    {
        int sum=0,count=0;
        for(int i=0;i<weights.length;i++)
        {
            sum += weights[i];
            if(sum>mid)
            {
                count++;
                sum = weights[i];
            }
        }
        count++;
        return count;
    }
}