class Solution {
    public void rotate(int[] nums, int k) 
    {
        int n=nums.length;
        if(n==0)
        return;
        k=k%n;
        if(k>n)
        return;
        int temp[]=new int[k];
       for(int i=n-k;i<n;i++)
       {
           temp[i-n+k]=nums[i];
       }
        for(int x=n-k-1; x>=0;x--)
        {
            nums[x+k]=nums[x];
        }
        for(int x=0;x<k;x++)
        {
            nums[x]=temp[x];
        }


    }
}