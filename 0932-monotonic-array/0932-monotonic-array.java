class Solution 
{
    public boolean isMonotonic(int[] nums) 
    {
        int n=nums.length;
        int i=0;
        if(n!=1 && nums[0]>nums[1])
        {
            for(int x=0;x<n-1;x++)
            {
                if(nums[x]<nums[x+1])
                {
                    return false;
                }
            
            }
        }
        else if(n!=1 && nums[0]<nums[1])
        {
            for(int x=0;x<n-1;x++)
            {
                if(nums[x]>nums[x+1])
                {
                    return false;
                }
            
            }
        }
        else{
            
            while(i<n-1 && (nums[i]==nums[i+1] ))
            {
                i++;
            }
            if( i<n-1 && nums[i]>nums[i+1])
           {
            for(int x=i;x<n-1;x++)
            {
                if(nums[x]<nums[x+1])
                {
                    return false;
                }
            
            }
        }
        else if(i<n-1 && nums[i]<nums[i+1])
        {
            for(int x=i;x<n-1;x++)
            {
                if(nums[x]>nums[x+1])
                {
                    return false;
                }
            
            }
        }

        }
       
      return true;   
    }
}