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
        // boolean seen[][] = new boolean[n][target+1];
        // boolean ans = canfind(n-1, target, nums, dp, seen);
        // return ans;

        for(int i = 0;i<n;i++)
        {
            dp[i][0] = true;
        }
        if(nums[0] == target)
        dp[0][target] = true;

        for(int i = 1;i<n;i++)
        {
            for(int j = 1;j<=target;j++)
            {
                boolean nonpick = dp[i-1][j];
                boolean pick = false;
                if(j >= nums[i])
                pick = dp[i-1][j-nums[i]];

                dp[i][j] = pick || nonpick;
            }
        }
        return dp[n-1][target];
    }

    // public boolean canfind(int ind, int target, int[] nums, boolean[][]dp, boolean[][] seen)
    // {
    //     if(target == 0)
    //     return true;

    //     if(ind == 0) return nums[0] == target;

    //     if(seen[ind][target] == true)
    //     return dp[ind][target];

    //     boolean nonpick = canfind(ind-1, target, nums, dp, seen);
    //     boolean pick = false;
    //     if(target >= nums[ind])
    //     pick = canfind(ind-1, target-nums[ind], nums, dp, seen);

    //     seen[ind][target] = true;
    //     dp[ind][target] = pick || nonpick;
    //     return dp[ind][target];
    // }
}