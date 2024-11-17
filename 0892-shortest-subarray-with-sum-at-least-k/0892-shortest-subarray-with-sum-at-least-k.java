class Solution {
    public int shortestSubarray(int[] nums, int k) 
    {
        // int min = Integer.MAX_VALUE-1;
        // for(int i = 0;i<nums.length;i++)
        // {
        //     int sum = 0;
        //     for(int j = i; j<nums.length;j++)
        //     {
        //         sum += nums[j];
        //         if(sum >= k)
        //         min = Math.min(min, j-i+1);
        //     }
        // } 
        // if(min == Integer.MAX_VALUE -1)
        // return -1; 

        // return min;      

        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        
        // Compute prefix sum
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        Deque<Integer> deque = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            // Ensure the sum of subarray [deque.peek(), i] >= k
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peek()] >= k) {
                minLength = Math.min(minLength, i - deque.poll());
            }

            // Remove indices from the deque where the prefix sum is greater than the current
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add current index to deque
            deque.offer(i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}