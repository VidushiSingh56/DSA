class Solution 
{
    public int rob(int[] nums) 
    {
        if(nums.length == 1)
        return nums[0];
        int prev2 = 0, prev1 = nums[0], cur = nums[0];
        for(int i = 1;i < nums.length-1; i++)
        {
            int pick = nums[i] + prev2;
            int nonpick = prev1;
            cur = Math.max(nonpick, pick);
            prev2 = prev1;
            prev1 = cur;
        }
        int ans1 = cur;

        prev2 = 0; prev1 = nums[1]; cur = nums[1];
        for(int i = 2;i < nums.length; i++)
        {
            int pick = nums[i] + prev2;
            int nonpick = prev1;
            cur = Math.max(nonpick, pick);
            prev2 = prev1;
            prev1 = cur;
        }
        int ans2 = cur;

        return Math.max(ans1, ans2);

    }
}