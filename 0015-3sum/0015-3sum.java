class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        //hashing
        // for(int i=0;i<nums.length;i++)
        // {
        //     HashSet<Integer> set = new HashSet<>();
        //     for(int j=i+1;j<nums.length;j++)
        //     {
        //          List<Integer> sub = new ArrayList<>();
        //         int third = -(nums[i]+nums[j]);
        //         if(set.contains(third)){
                   
        //             sub.add(nums[i]);
        //             sub.add(nums[j]);
        //             sub.add(third);
        //             Collections.sort(sub);
        //             if(!(ans.contains(sub)))
        //             {
        //                 ans.add(sub);
        //             }
                    
        //         }
        //         else{
        //             set.add(nums[j]);
        //         }
        //     }
        // }
        Arrays.sort(nums);
        int i,k,j;
        for( i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i]==nums[i-1])continue;
            j=i+1;
            k=nums.length-1;
            while(j<k)
            {
                List<Integer> sub = new ArrayList<>();
                int sum=nums[i]+nums[j]+nums[k];
                if(sum == 0)
                {
                   sub.add(nums[i]);
                   sub.add(nums[j]);
                   sub.add(nums[k]);
                   ans.add(sub);
                   j++;
                   k--;
                   while(j<k && nums[j]==nums[j-1])j++;
                   while(j<k && nums[k]==nums[k+1])k--;

                }
                else if(sum <0)
                {
                    j++;
                }
                else{
                    k--;
                }
            }

        }


        return ans;
    }
}