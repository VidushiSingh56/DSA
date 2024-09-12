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
            boolean flag = true;
            for(int j =0; j<words[i].length(); j++)
            {
                char cha = words[i].charAt(j);
                if(!ch.contains(cha))
                flag = false;
            }
            if(flag)
            ans++;
        }
        return ans;
    }
}