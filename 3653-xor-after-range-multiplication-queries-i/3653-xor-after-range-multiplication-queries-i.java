class Solution 
{
    public int xorAfterQueries(int[] nums, int[][] queries) 
    {
        for(int i = 0; i<queries.length;i++)
        {
            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];
            int v = queries[i][3];

            while(l <= r)
            {
                nums[l] = (int)(((long) nums[l] * v) % 1000000007);
                l = l + k;
            }
        }

        int bitwiseXOR = 0;
        for(int i = 0; i<nums.length;i++)
        {
            bitwiseXOR = bitwiseXOR ^ nums[i];
        }

        return bitwiseXOR;
    }
}