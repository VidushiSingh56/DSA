class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        int index = 0;
        List<List<Integer>> ans = new ArrayList<>();
        
        findComb(candidates, index, target, new ArrayList<>(), ans);
        return ans;

    }
    public void findComb(int[] arr, int i, int t,List<Integer> sub, List<List<Integer>> ans)
    {
        if(i==arr.length)
        {
            if(t==0)
            {
                ans.add(new ArrayList<>(sub));
            }
            return;
        }
        //condition to pick or not pick;
        if(arr[i]<=t)
        {
            sub.add(arr[i]);
            findComb(arr, i, t-arr[i], sub, ans);
            sub.remove(sub.size()-1);
        }
        findComb(arr, i+1, t, sub ,ans);
        
    }
}