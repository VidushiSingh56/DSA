import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        // Step 1: Sort events by their ending time
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        
        int n = events.length;
        int max_value = 0;

        // Step 2: Use an array to store the maximum value up to each event
        int[] maxUpTo = new int[n];
        maxUpTo[0] = events[0][2];

        for (int i = 1; i < n; i++) {
            maxUpTo[i] = Math.max(maxUpTo[i - 1], events[i][2]);
        }

        // Step 3: Iterate through events and find the best pair
        for (int i = 0; i < n; i++) {
            int value = events[i][2];
            
            // Binary search for the latest non-overlapping event
            int j = binarySearch(events, i);
            if (j != -1) {
                value += maxUpTo[j]; // Add the best value up to the non-overlapping event
            }

            // Update the maximum value
            max_value = Math.max(max_value, value);
        }

        return max_value;
    }

    // Binary search to find the latest event that ends before the current event starts
    private int binarySearch(int[][] events, int index) {
        int start = events[index][0];
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (events[mid][1] < start) {
                if (events[mid + 1][1] < start) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
