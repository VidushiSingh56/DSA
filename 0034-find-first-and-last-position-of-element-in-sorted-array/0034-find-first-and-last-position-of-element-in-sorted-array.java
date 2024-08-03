class Solution {
    public int[] searchRange(int[] nums, int target) 
    {
        int low=0, high=nums.length-1,mid=1;
        int start=-1,end=-1,flag=0;
        while(low<=high)
        {
            mid=(low+high)/2;
            if(nums[mid]==target)
            {
                flag++;
              break;

            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
         int right=mid;
         
         if(nums.length>0 && flag==1)
         {
            System.out.println(nums[right]);
             while((mid-1) >=0 &&  nums[mid]==nums[mid-1] )
               {
                mid--;
               }
               while((right+1) < nums.length && nums[right]==nums[right+1] )
               {
                right++;
               }
               start=mid; end=right; 
         }
              
              
        int ar[]={start, end};
        return ar;
        
    }
}