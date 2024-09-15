class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int i = 0, j = 0;

        while (j < s.length()) {
            char ch = s.charAt(j);

            if (map.containsKey(ch)) {
                // Update the left pointer 'i' only if it's behind or at the last occurrence of 'ch'
                i = Math.max(i, map.get(ch) + 1);
            }

            // Update the current character's index
            map.put(ch, j);

            // Calculate the current length and update max if necessary
            int len = j - i + 1;
            max = Math.max(max, len);

            // Move the right pointer forward
            j++;
        }

        return max;
    }
}
