class Solution 
{
    public int numTeams(int[] rating) 
    {
        int n = rating.length;
        int cut=0;
        for(int i = 0;i<n-2;i++)
        {
            for(int j = i+1;j<n-1;j++)
            {
                if(rating[i]>rating[j])
                {
                    for(int k = j+1; k<n; k++)
                    {
                        if(rating[j]>rating[k])
                        cut++;
                    }
                }

                else if(rating[i]<rating[j])
                {
                    for(int k = j+1; k<n; k++)
                    {
                        if(rating[j]<rating[k])
                        cut++;
                    }
                }
            }
        }
        return cut;
    }
}