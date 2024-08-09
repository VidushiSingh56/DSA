class Solution {
    public int smallestDivisor(int[] nums, int threshold) 
    {
      int min=1,max=findmax(nums);
      while(min<=max)
      {
        int mid=(min+max)/2;
        int div=check(nums, mid);
        if(div<=threshold)
        {
            max=mid-1;
        }
        else{
            min=mid+1;
        }
      }
      return min;   
    }

    public int check(int nums[], int mid)
    {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            double h = (double)nums[i]/mid;
            sum += (int)Math.ceil(h);
        }
        return sum;
    }

    public int findmax(int nums[])
    {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(max<=nums[i])
            max=nums[i];
        }
        return max;
    }
}