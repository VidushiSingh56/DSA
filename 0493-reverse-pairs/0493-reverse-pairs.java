
class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    // Modified mergeSort to count reverse pairs
    public int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;

        if (low < high) {
            int mid = (low + high) / 2;

            cnt += mergeSort(arr, low, mid); // Count in left half
            cnt += mergeSort(arr, mid + 1, high); // Count in right half
            cnt += countPairs(arr, low, mid, high); // Count reverse pairs between halves

            merge(arr, low, mid, high); // Merge the two halves
        }

        return cnt;
    }

    // Function to count the number of reverse pairs between two halves
    public int countPairs(int[] arr, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (right <= high && (long)arr[i] > 2 * (long)arr[right]) { // Use long to avoid overflow
                right++;
            }
            count += right - (mid + 1);
        }

        return count;
    }

    // Merge function to merge two sorted halves
    public void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // Temporary array
        int left = low; // Starting index of left half
        int right = mid + 1; // Starting index of right half

        // Merge the two halves into the temporary array
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // If elements on the left half are still remaining
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // If elements on the right half are still remaining
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Transfer sorted elements back into the original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}
