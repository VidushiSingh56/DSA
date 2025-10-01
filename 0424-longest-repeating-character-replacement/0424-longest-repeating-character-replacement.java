class Solution 
{
    public int characterReplacement(String s, int k) 
    {
        int freq[] = new int[26];
        int left = 0, right=0,max=0,n=s.length(),maxFreq=0;
        while(right < n)
        {
            freq[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right)-'A']);

            while((right - left + 1) - maxFreq > k)
            {
                freq[s.charAt(left)-'A']--;
                maxFreq=0;
                for(int i = 0;i<26;i++)
                {
                    maxFreq = Math.max(maxFreq, freq[i]);
                }
                left++;
            }

            max = Math.max(max, right-left+1);
            right++;
        }

        return max;
    }
}