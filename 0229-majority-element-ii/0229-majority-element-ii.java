class Solution {
    public List<Integer> majorityElement(int[] nums) 
    {
        int n=nums.length;
        List<Integer> list = new ArrayList<>();
        int cut1=0; int cut2=0; int ele1=Integer.MIN_VALUE; int ele2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(cut1==0 && ele2!=nums[i])
            {
                cut1=1;
                ele1=nums[i];
            }
            else if(cut2==0 && ele1!=nums[i])
            {
                cut2=1;
                ele2=nums[i];
            }
            else if(nums[i]==ele1)
            {
                cut1++;
            }
            else if(nums[i]==ele2)
            {
                cut2++;
            }
            else{
                cut1--;
                cut2--;
            }
        }
        int count1=0, count2=0;
        for(int i=0;i<n;i++)
        {
          if(nums[i]==ele1)
          {
            count1++;
            
          }
          if(nums[i]==ele2)
          {
            count2++;
          }
        }
        int mm = (int)Math.floor(n/3);
        if(count1>mm)
        {
          list.add(ele1);
        }
        if(count2>mm)
        {
          list.add(ele2);
        }
       
        return list;

    }
}