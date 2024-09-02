class Solution {
    List<List<Integer>> ans;

    public void getSubSets(int[] nums, int index, List<Integer> list) {
        ans.add(new ArrayList<>(list));
        for(int i=index;i<nums.length;i++) {
            if(i != index && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            getSubSets(nums, i+1, list);
            list.removeLast();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        getSubSets(nums, 0, new ArrayList<>());

        return ans;
    }
}