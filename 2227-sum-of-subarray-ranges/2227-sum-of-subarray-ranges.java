// import java.util.Stack;

class Solution {
    public long subArrayRanges(int[] nums) {
        return calculateSum(nums, true) - calculateSum(nums, false);
    }

    private long calculateSum(int[] nums, boolean isMax) {
        int n = nums.length;
        int[] next = new int[n];
        int[] prev = new int[n];
        Stack<Integer> st = new Stack<>();
        long sum = 0;

        // Calculate Previous Greater or Smaller Element (PGE or PSE)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && (isMax ? nums[st.peek()] <= nums[i] : nums[st.peek()] >= nums[i])) {
                st.pop();
            }
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        // Clear stack for next calculation
        st.clear();

        // Calculate Next Greater or Smaller Element (NGE or NSE)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && (isMax ? nums[st.peek()] < nums[i] : nums[st.peek()] > nums[i])) {
                st.pop();
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Calculate the sum
        for (int i = 0; i < n; i++) {
            int leftRange = i - prev[i];   // Distance to previous greater/smaller element
            int rightRange = next[i] - i;  // Distance to next greater/smaller element
            long subarrayCount = (long) leftRange * rightRange;
            sum += subarrayCount * nums[i];
        }

        return sum;
    }
}
