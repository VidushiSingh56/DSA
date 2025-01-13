class Solution 
{
    public int minimumLength(String s) 
    {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) 
            {
                map.put(ch, new ArrayList<>());
            }
            map.get(ch).add(i);
        }

        int count = 0;
    
        // int i = 0;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) 
        {
            Character key = entry.getKey();
            int size = entry.getValue().size(); 
            count += (size % 2 == 0) ? 2 : 1;
        }
        return count;
    }
}