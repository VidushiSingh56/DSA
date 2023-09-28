class Solution {
    public boolean check(int[] nums)
    {
        int n=nums.length;
        int count=0;
        int a[]=new int[n];
        int b[]=new int[n];
        for(int x=0;x<n;x++)
        {
            a[x]=nums[x];
        }
        Arrays.sort(a);
        for(int x=0;x<n;x++)
        {
            for(int i=0;i<n;i++)
            {
                b[i]=nums[(i+x)%n];
            }
            if(Arrays.equals(b,a))
            {
                count++;
                break;
            }
        }
        if(count==1)
        {
            return true;
        }
        return false;
        
    }
}