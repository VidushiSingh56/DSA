class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, breakpoint = -1;
        if (n == 1)
            return;


    
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakpoint = i;
                
                break;
            }
        }
        if(breakpoint == -1)
        {
            Arrays.sort(nums, 0, n);
            return;
        }
       
        for (int i = n - 1; i > breakpoint; i--)
        {
            if (nums[i] > nums[breakpoint]) 
            {
                int temp = nums[breakpoint];
                nums[breakpoint] = nums[i];
                nums[i] = temp;
                break;
            }
        }
       
        Arrays.sort(nums, breakpoint+1, n);
    }
}