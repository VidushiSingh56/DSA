import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();  // Map to store value-to-rank mapping
        int[] sorted = Arrays.stream(arr).distinct().sorted().toArray();  // Remove duplicates and sort
        
        // Assign ranks to sorted unique elements
        for (int i = 0; i < sorted.length; i++) {
            map.put(sorted[i], i + 1);
        }

        // Replace each element in the original array with its rank
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;  // Return the updated array

        // int n = arr.length;
        // int ans[] = new int[n];
        // List<Integer> hash = new ArrayList<>();
        // Arrays.fill(ans, 1);
        // for(int i=0;i<n;i++)
        // {
        //     if(!hash.contains(arr[i]))
        //     hash.add(arr[i]);
        // }
        // int size = hash.size();
        // for(int i =0;i<n;i++)
        // {
        //     for(int j=0;j<size;j++)
        //     {
        //         if(arr[i]>hash.get(j))
        //         {
        //             ans[i]++;
        //         }
        //     }
        // }
        // return ans;
    }
}
