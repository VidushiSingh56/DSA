class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // Step 1: Find the longest non-decreasing prefix
        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }

        // Step 2: If the entire array is non-decreasing
        if (left == n - 1) {
            return 0;  // The array is already sorted
        }

        // Step 3: Find the longest non-decreasing suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // Step 4: Minimum removal is removing the entire non-decreasing prefix or suffix
        int result = Math.min(n - left - 1, right);

        // Step 5: Check possible splits of prefix and suffix
        for (int i = 0; i <= left; i++) {
            int j = right;
            // Find the first element in the suffix where arr[i] <= arr[j]
            while (j < n && arr[i] > arr[j]) {
                j++;
            }
            result = Math.min(result, j - i - 1);
        }

        return result;
    }
}
