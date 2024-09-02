class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        letsdo(1, k, n, ans, sub);
        return ans;
    }
    public void letsdo(int i, int k, int n, List<List<Integer>> ans, List<Integer> sub)
    {
        if(k==0)
        {
            if(n==0)
            ans.add(new ArrayList<>(sub));
            
            return;
        }

        if(i>9 || i>n)return;

         sub.add(i);
        letsdo(i + 1, k - 1, n - i, ans, sub);
        sub.remove(sub.size() - 1); // Backtrack
        if(k==1 && n==i)return;
        letsdo(i + 1, k, n, ans, sub);
        
    }
}