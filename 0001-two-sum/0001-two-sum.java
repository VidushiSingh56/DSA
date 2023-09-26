class Solution 
{
     public int[] search(int nums[], int x, int z)
    {
        int n=nums.length;
       
        
       int arr[] = new int[2];
        int flag1=0;
       if(x!=z)
       {
        for(int y=0;y<n;y++)
        {
            if(nums[y]==x )
            {
                arr[flag1]=y;
                flag1++;
            }
             if(nums[y]==z )
            {
                arr[flag1]=y;
                flag1++;
            }
        }
       }
       else
       {
        for(int y=0;y<n;y++)
         {
            if(nums[y]==x )
            {
                arr[flag1]=y;
                flag1++;
                if(flag1==2)
                {
                  break;  
                }
                
            }
         }
       }
        return arr;
    }
    public int[] twoSum(int[] nums, int target) 
    {
        
        int n=nums.length;
       int a[]= new int[n];
       for(int x=0;x<n;x++)
       {
           a[x]=nums[x];
       }
       Arrays.sort(a);
       int k=0,l=0;
       int sum=0;
       int i=0,j=n-1;
       while(j<n && i<n)
       {
           sum=a[i]+a[j];
           if(sum<target)
           {
               i++;
           }
           else if(sum>target)
           {
              
               j--;
           }
           else
           {
              k=i;
              l=j;
              break;
           }
       }
        int result[] = search(nums, a[k], a[l]);
        // int array[] =new int[2];
        // result.toArray(array);

        
        return result;  
     
    }
   
}