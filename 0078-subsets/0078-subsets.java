class Solution {
    public List<List<Integer>> subsets(int[] nums) 
    {
        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        
        int index = 0;
        return findsubsets(index, nums, sub, answer);
        
    }
    public List<List<Integer>> findsubsets(int i, int[] nums, List<Integer>sub, List<List<Integer>>ans)
    {
        if(i >= nums.length)
        {
            ans.add(new ArrayList<>(sub));
            return ans;
        }
        sub.add(nums[i]);
        findsubsets(i+1, nums, sub, ans);
        sub.remove(sub.size() - 1);
        findsubsets(i+1, nums, sub, ans);
        return ans;
    }
}