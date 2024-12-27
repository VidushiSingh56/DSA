class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = Integer.MIN_VALUE;
        int maxLeft = values[0] + 0; // Initialize maxLeft as values[0] + 0 for the first element

        // Traverse from the second element onwards
        for (int j = 1; j < values.length; j++) {
            // Calculate the score for the current pair (i, j)
            maxScore = Math.max(maxScore, maxLeft + values[j] - j);

            // Update maxLeft for the next iteration
            maxLeft = Math.max(maxLeft, values[j] + j);
        }

        return maxScore;
    }
}
