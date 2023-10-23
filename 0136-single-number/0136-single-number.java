class Solution 
{
    public int singleNumber(int[] nums) 
    {
        int n=nums.length;
        int arr[]=new int[n];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int x=0;x<n;x++)
        {
            max=(max<nums[x])?nums[x]:max;
            min=(min>nums[x])?nums[x]:min;
        }
        max=Math.abs(max);
        min=Math.abs(min);
        int hash[]=new int[max+1];
        int hash1[]=new int[min];
        Arrays.fill(hash,0);
        Arrays.fill(hash1,0);
        for(int x=0;x<n;x++)
        {
            if(nums[x]>=0)
            {   
                hash[nums[x]]++;
                
            }
        }
        for(int x=0;x<n;x++)
        {
            if(nums[x]<0)
            {
               hash1[(Math.abs(nums[x]))-1]++;
               
            }
        }
        
        for(int x=0;x<max+1;x++)
        {
            System.out.print(hash[x]+" ");  
        }
        for(int x=0;x<min;x++)
        {
            System.out.print(hash1[x]+" ");  
        }
        for(int x=0;x<max+1;x++)
        {
            if(hash[x]==1)
            {
                
                return x;
            }
            
        }
        for(int x=0;x<min;x++)
        {
            if(hash1[x]==1)
            {

                return -(x+1);
            }
        }
        
        
        return -1;
    }
}