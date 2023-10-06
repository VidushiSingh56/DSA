class Solution 
{
    public void moveZeroes(int[] nums) 
    {
        int n=nums.length,j=-1;
        for(int x=0;x<n;x++)
        {
            if(nums[x]==0)
            {
                j=x;
                break;
            }
        }
      if(j!=-1)
      {
        for(int i=j+1;i<n;i++)
       {
           if(nums[i]!=nums[j])
           {
               int temp=nums[i];
               nums[i]=nums[j];
               nums[j]=temp;
               j++;
           }
       }
      }
     

    }
}