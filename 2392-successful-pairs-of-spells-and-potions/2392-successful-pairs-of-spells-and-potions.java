class Solution 
{
    public int[] successfulPairs(int[] spells, int[] potions, long success) 
    {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int pair[] = new int[n];
        for(int i = 0;i<n;i++)
        {
            int ind = binarysearch(potions, success, spells[i]);
            pair[i] = m-ind;
        }
        return pair;
    }
    public int binarysearch(int[] potions, long success, int val)
    {
        int min = 0, max = potions.length-1,ans=potions.length;
        while(min <= max)
        {
            int mid = min + (max-min)/2;
            long prod = (long) val * potions[mid];
            if(prod >= success)
            {   
                ans = mid;
                max=mid-1;
            }
            else
            {
                min=mid+1;
            }
        }
        return ans;
    }
}