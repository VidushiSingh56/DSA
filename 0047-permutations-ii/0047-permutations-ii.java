class Solution 
{
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        List<List<Integer>> arrayList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        backtrack(map, nums.length, arrayList, new ArrayList<>());
        return arrayList;
    }
    public void backtrack(Map<Integer, Integer> map, int n, List<List<Integer>> arrayList, List<Integer> list)
    {
        
        if(list.size() == n)
        {
            arrayList.add(new ArrayList<>(list));
            return;
        }
        for(int key : map.keySet())

        {
            if(map.get(key) <= 0)
            continue;
            
            list.add(key);
            map.put(key, map.get(key)-1);
        
            
            backtrack(map, n, arrayList, list);
            int number = list.get(list.size()-1);
            list.remove(list.size()-1);
            map.put(number, map.get(number)+1);
        }
        
    }
}