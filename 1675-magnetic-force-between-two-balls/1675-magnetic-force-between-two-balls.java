class Solution {
    public int maxDistance(int[] position, int m) 
    {
        int n=position.length;
           Arrays.sort(position);
        int low=1,high=position[n-1]-position[0];
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(canweplace(position, mid, m))
            {
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high;

    }
    public static boolean canweplace(int position[], int distance, int balls)
    {
        int countballs=1, lastpos=position[0], n= position.length;
        for(int i=1;i<n;i++)
        {
            if(position[i]-lastpos >= distance)
            {
                countballs++;
                lastpos=position[i];
            }
        }
        if(countballs>=balls)
        {
            return true;
        }
        return false;
    }
}