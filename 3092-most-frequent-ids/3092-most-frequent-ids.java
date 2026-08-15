class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) 
    {

        int n = nums.length;

        Map<Integer, Long> map = new HashMap<>();

        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        long[] ans = new long[n];

        for (int i = 0; i < n; i++) {

            int id = nums[i];

            long newFreq =
                map.getOrDefault(id, 0L) + freq[i];

            map.put(id, newFreq);

            pq.add(new long[]{newFreq, id});

            while (pq.peek()[0] != map.get((int)pq.peek()[1])) {
                pq.poll();
            }

            ans[i] = pq.peek()[0];
        }

        return ans;
    }
}