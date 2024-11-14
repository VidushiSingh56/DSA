class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
       int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        // If the total sum is odd, it cannot be partitioned into equal subsets
        if (totSum % 2 == 1) 
            return false;
       
            // Calculate the target sum for each subset
            int k = totSum / 2;
            // Create a DP table to store the results of subproblems
            boolean prev[] = new boolean[k + 1];
            

            prev[0] = true;
            

            if(arr[0]<=k)
            prev[arr[0]] = true;

            // Fill in the DP table using bottom-up dynamic programming
            for (int ind = 1; ind < n; ind++) 
            {
                boolean curr[] = new boolean[k + 1];
                curr[0] = true;
                for (int target = 1; target <= k; target++) 
                {
                    // Calculate if the current element is not taken
                    boolean notTaken = prev[target];

                    // Calculate if the current element is taken
                    boolean taken = false;
                    if (arr[ind] <= target) {
                        taken = prev[target - arr[ind]];
                    }

                    // Update the DP table for the current element and target sum
                    curr[target] = notTaken || taken;
                }

                prev = curr;
            }

            // The result is stored in the last cell of the DP table
            return prev[k];
        
    }
}
