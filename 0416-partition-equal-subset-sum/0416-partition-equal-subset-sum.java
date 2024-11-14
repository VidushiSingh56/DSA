// class Solution {
//     public boolean canPartition(int[] nums) 
//     {
//         int sum = 0;
//         for(int i =0;i<nums.length;i++)
//         {
//             sum += nums[i];
//         }
//         if(sum%2 != 0)
//         return false;
        
//         int dp[][] = new int[nums.length][(sum/2)+1];
//         for (int[] row : dp) 
//         {
//             Arrays.fill(row, -1);
//         }
//         return f(nums, nums.length-1, sum/2, dp); 
//     }
//     public boolean f(int[] num, int n, int target, int dp[][])
//     {
//         if(target == 0)
//         {
//             return true;
//         }

//         if(n<0)
//         return false;

//         if(dp[n][target] != -1)return dp[n][target] == 0 ? false : true;

//         boolean nonpick = f(num, n-1, target, dp);
//         boolean pick = false;
//         if(num[n]<=target)
//         pick = f(num, n-1, target-num[n], dp);
        
//         boolean ans = pick || nonpick;

//         dp[n][target] = ans == false ? 0 : 1; 
//         return dp[n][target] == 0 ? false : true;
//     }
// }



class Solution {
    public boolean canPartition(int[] nums) 
    {
        int n = nums.length;
        int sum = 0;
        
        
        
        for(int i =0;i<n;i++)
        {
            sum += nums[i];
        }
        int target = sum/2;
        int dp[][] = new int[n][target+1];

        if(sum % 2 == 1)
        return false;

        else
        {
            for(int i[] : dp)
            Arrays.fill(i, -1);
            if(check(nums, sum/2, n-1, dp) == 1)
            return true;
        }
        return false;
    }
    public int check(int nums[], int target, int ind, int[][] dp)
    {
        if(target == 0)
        return 1;

        if(ind == 0)
        return (nums[0] == target ? 1 : 0);

        if(dp[ind][target] != -1)
        return dp[ind][target];

        int nontake = check(nums, target, ind-1, dp);
        int take = 0;

        if(target>= nums[ind])
        take = check(nums, target-nums[ind], ind-1, dp);

        dp[ind][target] = (take == nontake && take == 0) ? 0 : 1;
        return dp[ind][target];
    }
}