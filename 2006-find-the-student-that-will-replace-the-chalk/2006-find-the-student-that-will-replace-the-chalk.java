class Solution {
    public int chalkReplacer(int[] chalk, int k) 
    {
        int n = chalk.length;
        long prefix[]=new long[n];
        prefix[0]=chalk[0];
        for(int i=1;i<n;i++)
        {
            prefix[i] = prefix[i-1] + chalk[i];
        }
        k=(int)(k%prefix[n-1]);
        int low = 0, high = n-1;
        while(low<high)
        {
            int mid = (low+high)/2;
            if(prefix[mid]<=k)
            {low=mid+1;}
            else
            {high = mid;}
        }
        return low;
    }
}