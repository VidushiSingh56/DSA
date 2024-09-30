import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        // Edge cases
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        // Memoization arrays for two cases
        int[] memo1 = new int[nums.length];
        int[] memo2 = new int[nums.length];
        Arrays.fill(memo1, -1); // Initialize the memo array with -1
        Arrays.fill(memo2, -1);

        // Compute the maximum by excluding either the first or the last house
        return Math.max(robFrom(nums, 0, nums.length - 2, memo1), robFrom(nums, 1, nums.length - 1, memo2));
    }

    // Recursive function with memoization for a linear house array
    private int robFrom(int[] nums, int start, int end, int[] memo) {
        // Base case
        if (start > end) return 0;

        // Check memoization array to avoid recomputation
        if (memo[start] != -1) return memo[start];

        // Recursive case: either rob the current house and skip the next, or skip the current house
        int robCurrent = nums[start] + robFrom(nums, start + 2, end, memo);  // Rob this house
        int skipCurrent = robFrom(nums, start + 1, end, memo);               // Skip this house

        // Store the result in memo and return
        memo[start] = Math.max(robCurrent, skipCurrent);
        return memo[start];
    }
}
