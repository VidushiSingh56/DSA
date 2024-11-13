//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static Boolean isSubsetSum(int arr[], int target) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][target + 1];

        // Initialize the dp array
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; // Sum 0 can be achieved by not picking any element
        }

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= target; k++) {
                boolean ntake = dp[i - 1][k];
                boolean take = false;

                if (k >= arr[i - 1]) // Check if current element can be included
                    take = dp[i - 1][k - arr[i - 1]];

                dp[i][k] = take || ntake; // Update dp array based on inclusion or exclusion
            }
        }
        return dp[n][target]; // Result is whether we can achieve 'target' with all elements
    }
}
