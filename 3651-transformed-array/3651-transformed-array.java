class Solution {
    public int[] constructTransformedArray(int[] nums) 
    {
        int n = nums.length;
        int result[] = new int[n];
        for(int i = 0;i<n;i++)
        {
            int k = nums[i];
            if(k > 0)
            {
                result[i] = nums[(i+k)%n];
            }
            else
            {
                int pos = (i+k);
                if(pos>=0)
                {
                    result[i] = nums[pos];
                }
                else
                {
                    pos = -pos;
                    int ans = (n- (pos%n))%n;
                    result[i] = nums[ans];
                }
            }
        }
        return result;
    }
}