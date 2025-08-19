class Solution {
    public long zeroFilledSubarray(int[] nums) 
    {
        int n = nums.length;
        long flag = 0, count = 0; 
        long sum = 0;
        for(int i = 0; i < n;i++)
        {
            if(nums[i] != 0)
            {
                sum += (flag == 1 ? findsum(count) : 0);
                flag = 0;
                count = 0;
                continue;
            }
            
            flag = 1;
            count++; 
        }
        if(flag == 1)
        {
            sum += findsum(count);
        }
        return sum;
    }
    public long findsum(long a)
    {
        long sum = 0;
        for(long i = 1; i<=a;i++)
        {
            sum = sum + i;
        }
        return sum;
    }


    // public long zeroFilledSubarray(int[] nums) {
    //     long sum = 0;
    //     long count = 0;

    //     for (int num : nums) 
    //     {
    //         if (num == 0) 
    //         {
    //             count++;          
    //             sum += count;     
    //         } 
    //         else 
    //         {
    //             count = 0;       
    //         }
    //     }

    //     return sum;
    // }
}
