class Solution {
    public boolean check(int[] nums) 
    {
        int n=nums.length;
        
        int flag=0;
        for(int i=0;i<n-1;i++)
        {
            if(nums[i] <= nums[i+1])
            {
                continue;
            }
            else
            {
                flag++;
            }
        }
        if(flag == 0)
        return true;
        else if(flag==1 && nums[n-1]<=nums[0])
        return true;
        else
        return false;
        

    }
    // public int findpivot(int nums[])
    // {
    //     int min=0,max=nums.length-1;
    //     while(min<max)
    //     {
    //         int mid=(min+max)/2;
    //         if(nums[0]<=nums[mid])
    //         {
    //             min=mid+1;

    //         }
    //         else{

    //         }
    //     }
    // }
}