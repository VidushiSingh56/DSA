class Solution 
{
    public int rob(int[] nums) 
    {
        // int prev2 = nums[0], prev1 = 0,cur = 0;
        // for(int i = 1;i < nums.length; i++)
        // {
        //     int pick = nums[i] + prev2;
        //     int nonpick = prev1;
        //     cur = Math.max(nonpick, pick);
        //     prev2 = prev1;
        //     prev1 = cur;
        // }
        // return cur;

        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i<n;i++)
        {
            int pick = nums[i] + ((i-2>=0) ? dp[i-2] : 0);
            int nonpick = dp[i-1];
            dp[i] = Math.max(pick, nonpick);
        }
        return dp[n-1];
    }
}