class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency array for characters in s1
        int[] s1Freq = new int[26];
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        // Frequency array for characters in the current window of s2
        int[] windowFreq = new int[26];
        int windowSize = s1.length();

        // First window in s2
        for (int i = 0; i < windowSize; i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // Check if the first window is a permutation of s1
        if (matches(s1Freq, windowFreq)) {
            return true;
        }

        // Slide the window over s2
        for (int i = windowSize; i < s2.length(); i++) {
            // Add the next character in the window
            windowFreq[s2.charAt(i) - 'a']++;
            // Remove the first character from the previous window
            windowFreq[s2.charAt(i - windowSize) - 'a']--;

            // Check if the current window matches the frequency of s1
            if (matches(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }

    // Helper function to compare frequency arrays
    private boolean matches(int[] s1Freq, int[] windowFreq) {
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != windowFreq[i]) {
                return false;
            }
        }
        return true;
    }
}
