class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) 
    {
        return atmost(nums, k)-atmost(nums,k-1);
    }
    public int atmost(int nums[], int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int left=0,right=0,n=nums.length,sum=0;
        while(right < n)
        {
            int r = nums[right];
            map.put(r,map.getOrDefault(r,0)+1);
            while(map.size() > k)
            {
                int l = nums[left];
                map.put(l,map.get(l)-1);
                if(map.get(l) == 0)
                map.remove(l);
                left++;
            }
            sum += right-left+1;
            right++;
        }
        return sum;
    }
}