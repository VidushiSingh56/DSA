class Solution {
    public int strStr(String haystack, String needle) 
    {
        int ans = -1;
        for(int i=0;i<haystack.length();i++)
        {
            if(haystack.charAt(i) == needle.charAt(0))
            {
                ans = match(haystack, i, needle);
                if(ans == 0)
                return i;
            }
        }
        return ans;
    }
    public int match(String haystack, int i, String needle)
    {
        int j=0;
        while(j<needle.length())
        {
            if(i==haystack.length() || haystack.charAt(i) != needle.charAt(j))
            {
                return -1;
            }
            i++;j++;
        }
        return 0;
    }
}