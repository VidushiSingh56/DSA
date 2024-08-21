class Solution {
    public boolean searchMatrix(int[][] matrix, int target)
    {
    //     int m=matrix.length;
    //     int n=matrix[0].length;
    //     int ans=0;
    //     int flag=0;
    //     int low=0, high=m-1;
    //     System.out.println(high);
    //     while(low<=high)
    //     {
    //         int mid=(low+high)/2;
    //         if(matrix[mid][0]==target)
    //         {
    //            return true;
    //         }
    //         else if(matrix[mid][0] < target)
    //         {
    //             low=mid+1;
    //         }
    //         else
    //         {
    //             high=mid-1;
    //         }
    //     }
    //     ans=high;
    //     System.out.println(low);
    //     System.out.println(ans);
    //     low=0;
    //     high=n-1;
    //     while(low<=high)
    //     {
    //         int mid=(low+high)/2;
    //         if(matrix[ans][mid]==target)
    //         {
    //             return true;
    //         }
    //         else if(matrix[ans][mid] < target)
    //         {
    //             low=mid+1;
    //         }
    //         else{
    //             high=mid-1;
    //         }
    //     }
        
    //    return false;



    int m=matrix.length;
    int n=matrix[0].length;
    for(int i=0;i<m;i++)
    {
        if(matrix[i][0]<=target && matrix[i][n-1]>=target)
        {
            int low=0,high=n-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(matrix[i][mid]==target)
                {
                    return true;
                }
                else if(matrix[i][mid]<target)
                {
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }

    }
    return false;


    }
}