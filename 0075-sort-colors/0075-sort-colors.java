class Solution 
{
    public void sortColors(int[] nums) 
    {
        int n=nums.length;
        int ar[]=new int[3];
        Arrays.fill(ar,0);
        for(int x=0;x<n;x++)
        {
            if(nums[x]==0)
            {
                ar[0]++;
            }
            else if(nums[x]==1)
            {
                ar[1]++;
            }
            else{
                ar[2]++;
            }
        }
        for(int x=0;x<ar[0];x++)
        {
            nums[x]=0;
           
        }
        for(int x=ar[0];x<ar[0]+ar[1];x++)
        {
            nums[x]=1;
            
        }
        for(int x=ar[0]+ar[1];x<n;x++)
        {
            nums[x]=2;
            
        } 
    } 
}
