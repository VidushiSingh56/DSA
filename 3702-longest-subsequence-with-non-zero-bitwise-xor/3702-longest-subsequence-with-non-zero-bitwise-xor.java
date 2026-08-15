class Solution {
    public int longestSubsequence(int[] nums) 
    {
        int flag = 0, xor = 0;
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] != 0)
            flag = 1;
            xor = xor ^ nums[i];
        }

       if(xor != 0)
       return nums.length;
       if(flag == 1)
       return nums.length - 1;
       return 0;

    }
}