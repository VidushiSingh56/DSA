class Solution {
    public int characterReplacement(String s, int k) 
    {
        int left = 0, right = 0, max = 0, maxfre = 0;
        int[] hash = new int[26];

        while (right < s.length()) 
        {
            char ch = s.charAt(right);
            hash[ch - 'A']++;
            maxfre = Math.max(maxfre, hash[ch - 'A']); // Track the maximum frequency of any character in the window.

            // If the number of characters we need to change exceeds k, shrink the window.
            if (right - left + 1 - maxfre > k) 
            {
                hash[s.charAt(left) - 'A']--; // Decrease the count of the left character.
                left++; // Shrink the window.
            }

            // Calculate the maximum length of the window that can be made valid.
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}


        // while(right<s.length())
        // {
        //     if(s.charAt(right) == 'B')B++;
        //     while(B>k)
        //     {
        //         if(s.charAt(left) == 'B')
        //         {
        //             B--;
        //         }                
        //         left++;
        //     }
        //     len = right-left+1;
        //     max = Math.max(len, max);
        //     right++;
        // }
        // return max;