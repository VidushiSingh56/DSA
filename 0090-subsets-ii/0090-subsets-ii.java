class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        generate(nums, 0, ans, sub);
        return ans;
        
    }
    public void generate(int nums[], int i,List<List<Integer>> ans, List<Integer> sub)
    {
        if(i==nums.length)
        {
                if(! ans.contains(sub))
                ans.add(new ArrayList<>(sub));
                return;
        }
        sub.add(nums[i]);
        generate(nums, i+1, ans, sub);
        sub.remove(sub.size()-1);
        generate(nums, i+1, ans, sub);
    }
}