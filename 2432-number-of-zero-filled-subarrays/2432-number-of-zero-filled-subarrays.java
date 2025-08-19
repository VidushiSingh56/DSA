class Solution {
    // public long zeroFilledSubarray(int[] nums) 
    // {
    //     int n = nums.length;
    //     int flag = 0, count = 0; 
    //     long sum = 0;
    //     for(int i = 0; i < n;i++)
    //     {
    //         if(nums[i] != 0)
    //         {
    //             sum += (int)(flag == 1 ? findsum(count) : 0);
    //             flag = 0;
    //             count = 0;
    //             continue;
    //         }
            
    //         flag = 1;
    //         count++; 
    //     }
    //     if(flag == 1)
    //     {
    //         sum += findsum(count);
    //     }
    //     return sum;
    // }
    // public int findsum(int a)
    // {
    //     int sum = 0;
    //     for(int i = 1; i<=a;i++)
    //     {
    //         sum = sum + i;
    //     }
    //     return sum;
    // }


    public long zeroFilledSubarray(int[] nums) {
        long sum = 0;
        long count = 0;

        for (int num : nums) 
        {
            if (num == 0) 
            {
                count++;          
                sum += count;     
            } 
            else 
            {
                count = 0;       
            }
        }

        return sum;
    }
}
