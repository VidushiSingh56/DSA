class Solution 
{
    public int trap(int[] height) 
    {
        int n = height.length;
        int nge[] = new int[n];
        int pge[] = new int[n];

        findnge(nge, height);
        findpge(pge, height);

        int total = 0;
        for(int i =0;i<n;i++)
        {
            int left = pge[i];
            int right = nge[i];

            if(left == -1 || right == -1)
            {
                continue;
            }

            total += Math.abs(Math.min(left, right) - height[i]);
        }

        return total;
    }
    public void findnge(int nge[], int height[])
    {
        int n = height.length;
        nge[n-1] = height[n-1];
        for(int i = n-2;i>=0;i--)
        {
            nge[i] = Math.max(nge[i+1], height[i]);
        }
    }

    public void findpge(int pge[], int height[])
    {
        int n = height.length;
        pge[0] = height[0];
        for(int i = 1;i<n;i++)
        {
            pge[i] = Math.max(pge[i-1], height[i]);
        }
    }
}