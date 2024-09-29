class Solution {
    public int rob(int[] nums)
    {
        int dp[] = new int [nums.length];
        for(int i =0;i<nums.length;i++)
        {
            dp[i] = -1;
        }
        return function(nums, nums.length-1, dp);
    }
    public int function(int nums[], int n, int dp[])
    {
        if(n==0)
        return dp[0] = nums[0];

        if(n<0)
        return 0;

        if(dp[n] != -1) return dp[n];
        int pick = nums[n] + function(nums, n-2, dp);
        int non = 0 + function(nums, n-1, dp);
        return dp[n] = Math.max(pick, non);
    }
}