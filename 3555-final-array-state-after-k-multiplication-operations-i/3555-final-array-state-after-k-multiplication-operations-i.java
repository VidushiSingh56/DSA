

import java.util.PriorityQueue;

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // Inner class to store value and index
        class Pair {
            int value; // The number in the array
            int index; // The index of the number in the array

            Pair(int value, int index) {
                this.value = value;
                this.index = index;
            }
        }

        // PriorityQueue (Min-Heap) to store numbers with their indices
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            // Compare by value; if values are equal, compare by index
            if (a.value == b.value) return a.index - b.index;
            return a.value - b.value;
        });

        // Add all elements from nums to the min-heap
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new Pair(nums[i], i));
        }

        // Perform k operations
        while (k-- > 0) {
            // Remove the smallest element from the heap
            Pair smallest = minHeap.poll();

            // Update the value with the multiplier
            nums[smallest.index] = smallest.value * multiplier;

            // Add the updated pair back into the heap
            minHeap.add(new Pair(nums[smallest.index], smallest.index));
        }

        // Return the updated array
        return nums;
    }
}





        // int n = nums.length;
        // for(int i = 0;i<k;i++)
        // {
        //     int min = Integer.MAX_VALUE, index=0;
        //     for(int j = 0;j<n;j++)
        //     {
        //         if(min>nums[j])
        //         {
        //             min =nums[j];
        //             index = j;
        //         }
        //     }
        //     System.out.print(index+"k ");
        //     nums[index] = nums[index] * multiplier;
            
        // }
        // return nums;