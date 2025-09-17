class Solution 
{
    public int findKthLargest(int[] nums, int k) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            pq.offer(nums[i]);
        }
    
    int i = 1;
    while(!pq.isEmpty())
    {
        if(i==k)
        {
            return pq.poll();
        }
        i++;
        pq.poll();
    }

    return pq.poll();
    }
}