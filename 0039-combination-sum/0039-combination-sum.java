class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        int index = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        return findComb(candidates, index, target, sub, ans);

    }
    public List<List<Integer>> findComb(int[] arr, int i, int t,List<Integer> sub, List<List<Integer>> ans)
    {
        if(i==arr.length)
        {
            if(t==0)
            {
                ans.add(new ArrayList<>(sub));
            }
            return ans;
        }
        //condition to pick or not pick;
        if(arr[i]<=t)
        {
            sub.add(arr[i]);
            findComb(arr, i, t-arr[i], sub, ans);
            sub.remove(sub.size()-1);
        }
        findComb(arr, i+1, t, sub ,ans);
        return ans;
    }
}