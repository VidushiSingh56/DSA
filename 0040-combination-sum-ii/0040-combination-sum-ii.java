class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findComb(candidates, 0, target, ans, new ArrayList<>());
        return ans;
        
    }
    public void findComb(int[] arr, int i, int t, List<List<Integer>>ans, List<Integer> sub)
    {
        if(t==0)
        {
            ans.add(new ArrayList<>(sub));
            return;
        }
        for(int j=i; j<arr.length;j++)
        {
            if(j > i && arr[j] == arr[j-1])continue;
            if(arr[j]>t)break;
            sub.add(arr[j]);
            findComb(arr, j+1, t-arr[j], ans, sub);
            sub.remove(sub.size()-1);
        }    
    }
}