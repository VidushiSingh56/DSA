class Solution 
{
    public int longestOnes(int[] nums, int k) 
    {
        int left=0, right = 0, n=nums.length, flip = 0,max=0;
        while(right < n)
        {
            if(nums[right] == 0)
            {
                flip++;
            }
            while(flip > k)
            {
                if(nums[left]==0)
                flip--;
                left++;
            }
            
            max = Math.max(max, right-left+1);
            right++;
        }

        return max;
    }
    
}