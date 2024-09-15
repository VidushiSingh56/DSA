class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0, max=0;
        int i =0, j=0;
        while(i<s.length() && j<s.length())
        {
            char ch = s.charAt(j);
            if(map.containsKey(ch))
            {
                i = Math.max(map.get(ch) + 1, i); 
                System.out.print(i + " ");
                map.put(ch, j);
            }
            map.put(ch, j);
            len = j-i+1;
            max = Math.max(max, len);
            j++;
        }
        return max;
    }
}