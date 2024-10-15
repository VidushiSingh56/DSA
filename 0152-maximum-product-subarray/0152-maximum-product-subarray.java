class Solution {
    public int maxProduct(int[] nums) 
    {
        int result = nums[0], prod=nums[0], prod2 = nums[0];
        for(int i =1;i<nums.length;i++)
        {
            int temp = Math.max(nums[i],Math.max(prod * nums[i], prod2 * nums[i]));
            prod2 = Math.min(nums[i],Math.min(prod * nums[i], prod2 * nums[i]));
            prod = temp;

            result=Math.max(result, prod);
        }
        return result;
    }
}