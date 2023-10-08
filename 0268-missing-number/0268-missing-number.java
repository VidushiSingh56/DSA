class Solution 
{
    public int missingNumber(int[] nums) 
    {
        int n=nums.length;
        int hash[]=new int[n+1];
        Arrays.fill(hash, 0);
        for(int x=0;x<n;x++)
        {
            hash[nums[x]]++;
        }
        for(int x=0;x<n+1;x++)
        {
            if(hash[x]==0)
            {
                return x;
            }
        }
        return -1;
    }
}