class Solution 
 {
    public boolean uniformArray(int[] nums) 
    {
        // record IntPair(int x, int y) {}
        int prevO = 0;
        int n = nums.length;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>(); 
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++)
        {
            min = Math.min(min, nums[i]);
            map.put(nums[i], prevO);
            if(nums[i] % 2 != 0)
            prevO++;
        }
        if(prevO == 0 || prevO == n)
        return true;

        for(int i = 0;i<n;i++)
        {
            if(min % 2 == 0)
            {
                //even
                if(nums[i] == min)
                continue;

                if(nums[i] % 2 == 0)
                {
                    continue;
                }
                else
                {
                    int evenA = map.get(nums[i]);
                    if(evenA < 1)
                    return false;
                }
            }
            else
            {
                //odd
                if(nums[i] % 2 == 0)
                {
                    int evenA = map.get(nums[i]);
                    if(evenA < 1)
                    return false;
                }
                else
                {
                continue;
                }
            }
        }

        return true;
    }
}