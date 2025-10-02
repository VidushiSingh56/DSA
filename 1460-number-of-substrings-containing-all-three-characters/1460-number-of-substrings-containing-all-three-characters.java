class Solution 
{
    public int numberOfSubstrings(String s) 
    {
        int left = 0, right = 0, n= s.length(), count=0, f[] = new int[3];
        while(right < n)
        {
            char ch = s.charAt(right);
            f[ch-'a']++;

            while(f[0] > 0 && f[1] > 0 && f[2] > 0)
            {
                count += n-right;
                f[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return count;
    }
}