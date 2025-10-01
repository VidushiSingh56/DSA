class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        if(s.length() == 0)
            return 0;

        int arr[] = new int[128];   // ✅ instead of 26 (works for all ASCII)
        char[] ch = s.toCharArray();
        int l = 0, r = 0, n = s.length(), max = 0;

        while(r < n)
        {
            int c = ch[r];
            arr[c]++;

           
            while(arr[c] > 1)
            {
                arr[ch[l]]--;
                l++;
            }

            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
