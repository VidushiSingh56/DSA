class Solution {
    public int maxScore(int[] cardPoints, int k) 
    {
        int n = cardPoints.length;
        
        // Calculate the initial sum of the first k cards from the left
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += cardPoints[i];
        }
        
        // Initialize maxScore with the current sum of the first k cards
        int maxScore = currentSum;
        
        // Now try to slide from the right end
        // Take cards from the right and remove from the left
        for (int i = 0; i < k; i++) {
            currentSum = currentSum - cardPoints[k - 1 - i] + cardPoints[n - 1 - i];
            maxScore = Math.max(maxScore, currentSum);
        }
        
        return maxScore;
    }
}
