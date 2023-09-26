class Solution 
{
    public  List<List<Integer>> threeSum(int[] nums) 
    {
        
         Set<List<Integer>> st=new HashSet<>();
        // List<Integer> temp=new ArrayList<>();
        int n=nums.length;
        
        for(int i=0;i<n;i++)
        {  Set<Integer> list= new HashSet<>();
            for(int j=i+1;j<n;j++)
            {
                int k=-(nums[i]+nums[j]);
                if(list.contains(k))
                {
                    List<Integer> temp = Arrays.asList(nums[i],nums[j], k);
                    temp.sort(null);
                    st.add(temp);
                   
                }
                list.add(nums[j]);
            }
        }
        List<List<Integer>> mylist = new ArrayList<>(st);
        return mylist;
    }
}