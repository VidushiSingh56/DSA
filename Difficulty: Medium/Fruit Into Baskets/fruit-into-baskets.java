//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalFruits(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(Integer[] arr) 
    {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right =0, len=0 , max = 0;
        while(right<arr.length)
        {
            if(!map.containsKey(arr[right]))
            {
                map.put(arr[right], 1);
            }
            else
            {
                map.put(arr[right], map.get(arr[right])+1);
            }
            while(map.size() > 2)
            {
                map.put(arr[left], map.get(arr[left])-1);
                if(map.get(arr[left]) == 0)
                {
                    map.remove(arr[left]);
                }
                left++;
            }
            len = right-left+1;
            max = Math.max(len, max);
            right++;
        }
        return max;
    }
}