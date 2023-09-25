class Solution
 {
    public int search(int[] nums, int target)
     {
       int n=nums.length,min=0,max=n-1,mid=0,g=0;
       if(n>1)
       {
       while(min<=max)
       { mid=(int)(min+max)/2;
           if(target==nums[mid])
           {
               g++;break;
           }
           else if(target>nums[mid])
           {
             min=mid+1;
           }
           else
           {
               max=mid-1;
           }
       }
       
       if(g==0)
       {
           return -1;
       }
       else
       {
           return mid;
       }
    }
    else
    {
        if(target==nums[0])
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }
    }
}