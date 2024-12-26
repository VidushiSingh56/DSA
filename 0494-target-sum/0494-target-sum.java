class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findSum(nums, target, 0, 0);
    }

    private int findSum(int[] nums, int target, int currentSum, int i) {
        // Base case
        if (i == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        // Recursive calls
        int add = findSum(nums, target, currentSum + nums[i], i + 1);
        int subtract = findSum(nums, target, currentSum - nums[i], i + 1);

        return add + subtract;
    }
}
