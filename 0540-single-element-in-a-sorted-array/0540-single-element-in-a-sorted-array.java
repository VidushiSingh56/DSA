class Solution {
    public int singleNonDuplicate(int[] nums) 
    {
        // int xor=0;
        // for(int i=0;i<nums.length;i++)
        // {
        //     xor=xor ^ nums[i];
        // }
        // return xor;
        int n=nums.length;
        if(n==1)
        return nums[0];
        if(nums[0]!=nums[1])
        return nums[0];
        if(nums[n-1] != nums[n-2])
        return nums[n-1];

        int min=1, max=n-2;
        while(min<=max)
        {
            int mid=(min+max)/2;
            int pos=mid%2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
            return nums[mid];
            else if((pos != 0 && nums[mid]==nums[mid-1]) || (pos == 0 && nums[mid]==nums[mid+1]))
            {
                min=mid+1;
            }
            else{
               max=mid-1; 
            }
        }
        return nums[min];
    }
}