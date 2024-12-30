class Solution 
{
    int mod = 1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) 
    {
        int ans = 0;
        int ar[] = new int[high+1];
        Arrays.fill(ar, -1);
        for(int i = low;i<=high;i++)
        {
            ans += dfs(i, zero, one, ar);
            ans = ans % mod;
        }

        return ans;
    }
    public int dfs(int i, int zero, int one, int[] ar)
    {
        int count = 0;
        if(i==0)
        {
            ar[0] = 1;
        }

        if(ar[i] != -1)
        return ar[i];

        if(i>=one)
        {
            count += dfs(i-one, zero, one, ar);
        }
        if(i>=zero)
        {
            count += dfs(i-zero, zero, one, ar);
        }

        ar[i] = count % mod;
        return ar[i];
    }
}