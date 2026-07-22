class Solution 
{
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> answerList = new ArrayList<>();
        getpermutations(nums, nums.length, answerList, new ArrayList<>());
        return answerList;
    }

    public void getpermutations(int[] nums, int n, List<List<Integer>>answerList, List<Integer> list)
    {
        if(list.size() == n)
        {
            answerList.add(new ArrayList<>(list));
            return;
        }
        for(int a=0;a<n;a++)
        {
            if(list.contains(nums[a]))
            continue;
            list.add(nums[a]);
            getpermutations(nums, nums.length, answerList, list);
            list.remove(list.size()-1);
        }
    }

}
