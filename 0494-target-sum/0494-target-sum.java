class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        // Calculate the total sum of the array
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If target is not reachable, return 0
        if (Math.abs(target) > sum) return 0;

        // Create a DP array with offset to handle negative sums
        int offset = sum;
        int[][] dp = new int[n][2 * sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Initialize DP array with -1 for memoization
        }

        return findSum(nums, target, 0, 0, dp, offset);
    }

    private int findSum(int[] nums, int target, int currentSum, int i, int[][] dp, int offset) {
        // Base case
        if (i == nums.length) {
            return (currentSum == target) ? 1 : 0;
        }

        // Check memoized result
        if (dp[i][currentSum + offset] != -1) {
            return dp[i][currentSum + offset];
        }

        // Recursive calls
        int add = findSum(nums, target, currentSum + nums[i], i + 1, dp, offset);
        int subtract = findSum(nums, target, currentSum - nums[i], i + 1, dp, offset);

        // Memoize the result
        dp[i][currentSum + offset] = add + subtract;

        return dp[i][currentSum + offset];
    }
}
