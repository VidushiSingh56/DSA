class Solution {
    public int findPeakElement(int[] nums)
    {
        int n=nums.length;
        
        if(n==1)
        return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        int min=1, max=n-2;
        while(min<=max)
        {
            int mid= (min+max)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
            {
                return mid;
            }
            else if(nums[mid]>nums[mid-1])
            {
                min=mid+1;
            }
            else{
                max=mid-1;
            }
        }
        return -1;
    }
}