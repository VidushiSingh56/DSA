class Solution 
{
    public List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> arrayList = new ArrayList<>();
       
        getPermutations(n,k,1,arrayList,new ArrayList<>());
        return arrayList;
    }
    public void getPermutations(int n, int k, int i, List<List<Integer>> arrayList, List<Integer> list)
    {
        if(list.size() == k)
        {
            arrayList.add(new ArrayList<>(list));
            return;
        }
        for(int j = i;j<=n;j++)
        {
            list.add(j);
            getPermutations(n, k, j+1, arrayList, list);
            list.remove(list.size()-1);
        }
           
        // }
    }
}