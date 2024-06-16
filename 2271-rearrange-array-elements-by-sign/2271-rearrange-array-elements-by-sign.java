class Solution {
    public int[] rearrangeArray(int[] nums) 
    {
        int n=nums.length;
        int a[]=new int[n];
        int pos=0,neg=1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>=0)
            {
                a[pos]=nums[i];
                pos+=2;
            }
            else
            {
                a[neg]=nums[i];
                neg+=2;
            }
        }
        return a;
    }
}