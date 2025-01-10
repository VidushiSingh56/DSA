class Solution 
{
    public int prefixCount(String[] words, String pref) 
    {
        int count=0;
        for(int i = 0;i<words.length;i++)
        {
            String s = words[i];
            if(s.startsWith(pref))
            count++;
        }
        return count;
    }
}