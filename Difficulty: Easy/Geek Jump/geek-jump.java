//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int arr[], int N)
    {
        int dp[] =  new int[N];
        for(int i =0;i<N;i++)
        {
            dp[i] = -1;
        }
        return function(arr, N-1, dp);
    }

    public int function(int arr[], int N, int dp[])
    {
        if (N == 0)
        return dp[0] = 0;
        
        if(dp[N] != -1) return dp[N];
        int left = function(arr, N-1, dp) + Math.abs(arr[N] - arr[N-1]);
        int right = Integer.MAX_VALUE;
        if (N > 1)
            right = function(arr, N-2, dp) + Math.abs(arr[N] - arr[N-2]);

        // Return the minimum energy between the two possible jumps.
        return dp[N] = Math.min(left, right);
    }
}