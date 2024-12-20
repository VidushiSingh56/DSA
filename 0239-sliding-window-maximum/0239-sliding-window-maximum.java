class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(); // Stores indices
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index = 0;

        for (int i = 0; i < n; i++) {
            // Remove elements outside the current window
            if (!deque.isEmpty() && deque.getFirst() < i - k + 1) {
                deque.removeFirst();
            }

            // Remove smaller elements from the back of the deque
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }

            // Add the current element's index to the deque
            deque.addLast(i);

            // Add the maximum of the current window to the result
            if (i >= k - 1) {
                result[index++] = nums[deque.getFirst()];
            }
        }

        return result;
    }
}
