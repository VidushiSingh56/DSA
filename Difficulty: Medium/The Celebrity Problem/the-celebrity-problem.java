//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) 
    {
        // code here
        int n = mat.length;
        int top = 0, down = n-1;
        while(top < down)
        {
            if(mat[top][down] == 1)
            top++;
            
            else if(mat[down][top] == 1)
            down --;
            
            else
            {
                top++;
                down--;
            }
        }
        int flag = 0;
        if(top == down)
        {
            for(int i = 0;i<n;i++)
            {
                if(top == i && mat[top][i] == 0)
                {
                    flag++;
                    continue;
                }
                if(mat[top][i] == 0 && mat[i][top] == 1)
                {
                    flag++;
                }
            }
            if(flag == n)
            {
                return top;
            }
        }
        return -1;
    }
}