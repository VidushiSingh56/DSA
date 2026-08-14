class Solution {
    public int maximumLengthSubstring(String s) 
    {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, count = 0, n=s.length(), max = Integer.MIN_VALUE;
        while(j<n)
        {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            count++;
            while(map.get(c) > 2)
            {
                char ch = s.charAt(i);
                map.put(ch, map.get(ch)-1);
                i++;
                count = j-i+1;
            }
            max = Math.max(max, count);
            j++;
            
        }

        return max;
    }
}