class Solution {
    public int maxProduct(int[] nums) 
    {
        int result = nums[0], prev=nums[0], prev2 = nums[0];
        for(int i =1;i<nums.length;i++)
        {
            int temp = Math.max(nums[i],Math.max(prev * nums[i], prev2 * nums[i]));
            prev2 = Math.min(nums[i],Math.min(prev * nums[i], prev2 * nums[i]));
            prev = temp;

            result=Math.max(result, prev);
        }
        return result;
    }
}