class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) 
    {
        return function(nums,goal)-function(nums, goal-1);
    }
    public int function(int nums[], int goal)
    {
        if(goal<0)
        return 0;

        int right =0, left =0, count=0,sum=0;
        while(right<nums.length)
        {
            sum+=nums[right];
            System.out.print(sum+" ");
            while(sum>goal)
            {
                sum-=nums[left];
                left++;
            }
            count=count+right-left+1;
            right++;
        }
        System.out.println();
        return count;

    }
}