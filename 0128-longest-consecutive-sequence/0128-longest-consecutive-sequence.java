class Solution {
    public int longestConsecutive(int[] nums) 
    {
         if(nums.length ==0)
        return 0;
        Arrays.sort(nums);
        int lastSmallest=nums[0];int cutcurr=1;int longest=1;

       
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]-1 == lastSmallest)
            {
                cutcurr++;
                lastSmallest=nums[i];
                continue;
            }
            if(nums[i] == lastSmallest)
            continue;

            longest=Math.max(longest,cutcurr);
            cutcurr=1;
        }
        longest=Math.max(longest,cutcurr);
        return longest;
    }
}