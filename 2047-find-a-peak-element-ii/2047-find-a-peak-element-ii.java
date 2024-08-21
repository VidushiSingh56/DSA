class Solution {
    public int[] findPeakGrid(int[][] mat) 
    {
        int m=mat.length;
        int n=mat[0].length;

        int low=0,high=n-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int max=-1;
            int row=0;
            for(int i=0;i<m;i++)    //max ele
            {
                if(mat[i][mid]>max)
                {
                    max=mat[i][mid];
                    row=i;
                }
            }
            int left= (mid-1)>=0?mat[row][mid-1]:-1;
            int right= (mid+1)<n?mat[row][mid+1]:-1;
            if(max>left && max>right)
            {
                int arr[]={row,mid};
                return arr;
            }
            else if(max<left)
            high=mid-1;
            else
            low=mid+1;
        }
        int arr[]={-1,-1};
        return arr;
    }
}