class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        List<List<Integer>> ans= new ArrayList<>();
      int n=nums.length;
      //hashing
    //   for(int i=0;i<n;i++)
    //   {
    //     for(int j=i+1;j<n;j++)
    //     {
    //         HashSet<Integer> set = new HashSet<Integer>();
    //         for(int k=j+1;k<n;k++)
    //         {
    //             int fourth = target-(nums[i]+nums[j]+nums[k]);
    //             if(set.contains(fourth))
    //             {
    //                 List<Integer> sub= new ArrayList<>();
    //                 sub.add(nums[i]);
    //                 sub.add(nums[j]);
    //                 sub.add(nums[k]);
    //                 sub.add(fourth);
    //                 Collections.sort(sub);
    //                 if(!(ans.contains(sub)))
    //                 {
    //                     ans.add(sub);
    //                 }
                    
    //             }
    //             else{
    //                 set.add(nums[k]);
    //             }
    //         }
    //     }
    //   } 

    Arrays.sort(nums);
    for(int i=0;i<n;i++)
    {
        if(i>0 && nums[i]==nums[i-1])continue;
        for(int j=i+1;j<n;j++)
        {
            if(j!=(i+1) && nums[j]==nums[j-1])continue;

            int k=j+1;
            int l= n-1;
            while(k<l)
            {
                long sum = nums[i];
                sum+=nums[j];
                sum+=nums[k];
                sum+=nums[l];
                
                if(sum<target)
                {
                    k++;
                }
                else if(sum>target)
                {
                    l--;
                }
                else{
                     List<Integer> sub= new ArrayList<>();
                     
                    sub.add(nums[i]);
                    sub.add(nums[j]);
                    sub.add(nums[k]);
                    sub.add(nums[l]);
                    if(!(ans.contains(sub)))
                    ans.add(sub);
                    System.out.println(i+" "+j+" "+k+" "+l);
                    
                    
                    k++;l--;
                    if(k<l && nums[k]==nums[k-1])k++;
                    if(k<l && nums[l]==nums[l+1])l--; 
                    
                }
            }
        }
    }
      return ans; 
    }
}