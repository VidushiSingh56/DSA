class Solution {
    public int countConsistentStrings(String allowed, String[] words) 
    {
        int n = allowed.length();
        HashSet<Character> ch = new HashSet<>();
        for(int i = 0; i<n;i++)
        {
            ch.add(allowed.charAt(i));
        }
        int ans =0;
        for(int i = 0; i<words.length;i++)
        {
            int flag = 0;
            for(int j =0; j<words[i].length(); j++)
            {
                char cha = words[i].charAt(j);
                if(ch.contains(cha))
                flag++;
            }
            if(flag == words[i].length())
            ans++;
        }
        return ans;
    }
}