class Solution 
{
    public int maxScore(int[] cardPoints, int k) 
    {
        int n = cardPoints.length;
        int sum = 0, max = 0;
        for(int i = 0;i<k;i++)
        {
            sum += cardPoints[i];
        }

        max=Math.max(max, sum);
        if(k==n)
        return max;
        int j = k-1, l=1;
        while(j>=0)
        {
            sum -= cardPoints[j];
            j--;
            sum += cardPoints[n-l];
            l++;
            max = Math.max(sum, max);
        }
        return max;
    }
}