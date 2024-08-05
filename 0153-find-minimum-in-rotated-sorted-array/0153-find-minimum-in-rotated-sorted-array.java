class Solution {
    public int findMin(int[] nums) 
    {
        int min=0, max=nums.length-1;
        
        while(min<max)
        {
            int mid=min + (max-min)/2;
            if(nums[mid]>=nums[0])
            {
                min=mid+1;
            }
            else{
                max=mid;
            }
        }
        if(min==nums.length-1 && nums[min]>nums[0]) 
        {
            return nums[0];
        }
        return nums[min];
        
    }
}