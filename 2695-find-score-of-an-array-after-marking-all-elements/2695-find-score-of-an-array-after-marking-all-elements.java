
class Solution {
    public long findScore(int[] nums) 
    {
        int n = nums.length;
        long sum = 0;
        boolean marked[] = new boolean[n];
        PriorityQueue<int[]> heap = new PriorityQueue<>((arr1, arr2) -> {
            if(arr1[0] != arr2[0]) return arr1[0]-arr2[0];

            return arr1[1] - arr2[1];
        });

        for(int i = 0;i<n;i++)
        {
            heap.add(new int[]{nums[i],i});
        }
        
        while(!heap.isEmpty())
        {
            int element[] = heap.remove();
            int number = element[0];
            int index = element[1];

            if(!marked[index])
            {
                sum += number;
                marked[index] = true;

                if(index-1>=0)
                {
                    marked[index-1] = true;
                }
                if(index+1<n)
                {
                    marked[index+1] = true;
                }
            }
        }
        return sum;
    }
    
}