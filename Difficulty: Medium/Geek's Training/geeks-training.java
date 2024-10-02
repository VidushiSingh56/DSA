//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr, N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][], int N) {
        // Create a DP array of size N (days) by 4 (last task including 3 options + 1 for no task)
        int[][] dp = new int[N][4];
        
        // Base case: On day 0, you can select the maximum points for each last task scenario
        for (int last = 0; last <= 3; last++) {
            dp[0][last] = 0;
            for (int task = 0; task <= 2; task++) {
                if (task != last) {
                    dp[0][last] = Math.max(dp[0][last], arr[0][task]);
                }
            }
        }
        
        // Build the DP table for the rest of the days
        for (int day = 1; day < N; day++) {
            for (int last = 0; last <= 3; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        dp[day][last] = Math.max(dp[day][last], arr[day][task] + dp[day - 1][task]);
                    }
                }
            }
        }
        
        // The final answer is the maximum value on the last day considering no restriction on the last task
        return dp[N - 1][3];
    }
}
