class Solution {
    public int searchInsert(int[] nums, int target) 
    {
        int n=nums.length;
        int min=0,max=n-1,ans=0;
        while(min<=max)
        { int mid=(min+max)/2;
            if(min==max)
            {
                if(nums[min]<target)
                {
                    ans=min+1;break;
                }
                 if(nums[min]>target)
                {
                    ans=min;break;
                }


            }
        
            if(nums[mid]<target)
            {
                min=mid+1;
            }
            else if(nums[mid]>target)
            {
                max=mid;
            }
            else if(nums[mid]==target)
            {
                ans=mid;
                break;
            }

            
        }
        return ans;
    }
}