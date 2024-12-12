// class Solution 
// {
//     public long pickGifts(int[] gifts, int k) 
//     {
//         int n = gifts.length;
//         Arrays.sort(gifts);
//         while(k-- > 0)
//         {
//             int sq = (int)Math.floor(Math.sqrt(gifts[n-1]));
//             gifts[n-1] = sq;
//             Arrays.sort(gifts);
//         }
//         long sum_of_gifts = 0;
//         for(int i = 0;i<n;i++)
//         {
//             sum_of_gifts += gifts[i];
//         }
//         return sum_of_gifts;
//     }
// }

// class Solution 
// {
//     public long pickGifts(int[] gifts, int k) 
//     {
//         List<Integer> sortedGifts = new ArrayList<>();
//         long sum = 0;
//         int n = gifts.length;
//         for(int i = 0;i<gifts.length;i++)
//         {
//             sortedGifts.add(gifts[i]);
//         }
//         Collections.sort(sortedGifts);
//         for(int i = 0;i<k;i++)
//         {

//             // Get the largest element (last element in the sorted list)
//             int maxElement = sortedGifts.get(n - 1);
//             sortedGifts.remove(n - 1);

//             // Calculate the square root of the max element
//             int sqrtElement = (int) Math.floor(Math.sqrt(maxElement));

//             // Find the index where the square root should be inserted
//             int spotOfSqrt = Collections.binarySearch(sortedGifts, sqrtElement);

//             // If the value isn't found, binarySearch returns a negative index
//             if (spotOfSqrt < 0) {
//                 spotOfSqrt = -(spotOfSqrt + 1);
//             }

//             sortedGifts.add(spotOfSqrt, sqrtElement); // Insert the square root at the correct index
//         }
       
//         for(int num : sortedGifts)
//         {
//             sum += num;
//         }
//         return sum;
//     }
// }



class Solution 
{
   public long pickGifts(int[] gifts, int k) 
    {
        List<Integer> giftList = new ArrayList<>();
        for(int i : gifts)
        {
            giftList.add(-i);
        }
        PriorityQueue<Integer> giftHeap = new PriorityQueue<>(giftList);
        for(int i = 0;i<k;i++)
        {
            int max = -giftHeap.poll();
            
            int sqrt = (int)Math.floor(Math.sqrt(max));
            giftHeap.offer(-sqrt);
        }
        
        long sum = 0;
        while(!giftHeap.isEmpty())
        {
            sum += -giftHeap.poll();
        }
        return sum;
    }
}