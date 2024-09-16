class Solution {
    public int longestOnes(int[] nums, int k) 
    {
        // int l = 0, r=0, len=0,max=0, zero = 0;
        // while(r<nums.length)
        // {
        //     if(nums[r] == 0)
        //     zero++;

        //     while(zero>k)
        //     {
        //         if(nums[l] == 0)zero--;
        //         l++;
        //     }
        //     len = r-l+1;
        //     max = Math.max(max, len);
        //     r++;
        // }
        // return max;

//removing the while loop
        int l = 0, r=0, len=0,max=0, zero = 0;
        while(r<nums.length)
        {
            if(nums[r] == 0)
            zero++;

           if(zero > k)
           {
            if(nums[l] == 0)
            {
                zero --;
            }
            l++;
           }
           
            if(zero<=k)
            {
                len = r-l+1;
                max = Math.max(len, max);
            }
            r++;
        }
        return max;



    }
}