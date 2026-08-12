class Solution {
    public int maxSubarrayLength(int[] nums, int k) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        int count = 0;
        int maxLength = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            count++;
            
            while(map.get(nums[i]) > k)
            {
                map.put(nums[j], map.get(nums[j])-1);
                j++;
                count = i-j+1;
            }
            maxLength = maxLength < count ? count : maxLength;
        }
        return maxLength;
    }
}