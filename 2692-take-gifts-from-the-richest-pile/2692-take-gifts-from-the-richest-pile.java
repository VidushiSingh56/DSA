class Solution 
{
    public long pickGifts(int[] gifts, int k) 
    {
        int n = gifts.length;
        Arrays.sort(gifts);
        while(k-- > 0)
        {
            int sq = (int)Math.floor(Math.sqrt(gifts[n-1]));
            gifts[n-1] = sq;
            Arrays.sort(gifts);
        }
        long sum_of_gifts = 0;
        for(int i = 0;i<n;i++)
        {
            sum_of_gifts += gifts[i];
        }
        return sum_of_gifts;
    }
}