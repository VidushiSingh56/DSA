class Solution 
{
    public void sortColors(int[] nums) 
    {
       int n=nums.length;
       
        for(int x=0;x<n;x++)
       {
           for(int y=0;y<n;y++)
           {
               if(nums[x]<nums[y])
               {
                   int temp=nums[x];
                   nums[x]=nums[y];
                   nums[y]=temp;
               }
           }
       }} 
    }
