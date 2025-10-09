class Solution 
{
    public boolean canPartition(int[] nums) 
    {
        int sum=0;
        for(int i =0;i<nums.length;i++)
        {
            sum += nums[i];
        }
        if(sum%2 != 0)
        return false;
        int target = sum/2;
        int n = nums.length;
        boolean dp[][] = new boolean[n][target+1];
        boolean seen[][] = new boolean[n][target+1];
        boolean ans = canfind(n-1, target, nums, dp, seen);
        return ans;
    }

    public boolean canfind(int ind, int target, int[] nums, boolean[][]dp, boolean[][] seen)
    {
        if(target == 0)
        return true;

        if(ind == 0) return nums[0] == target;

        if(seen[ind][target] == true)
        return dp[ind][target];

        boolean nonpick = canfind(ind-1, target, nums, dp, seen);
        boolean pick = false;
        if(target >= nums[ind])
        pick = canfind(ind-1, target-nums[ind], nums, dp, seen);

        seen[ind][target] = true;
        dp[ind][target] = pick || nonpick;
        return dp[ind][target];
    }
}