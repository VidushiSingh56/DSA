//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) 
    {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        int n= mat.length;
        int[][] visited = new int[mat.length][mat.length];
        if (mat[0][0] == 1) {
            solve(0, 0, mat, ans, "", visited);
        }
        return ans;
        
    }
    public void solve(int i, int j, int[][] mat, ArrayList<String> ans, String sub,int[][] visited)
    {
        int n = mat.length;
        if(i==n-1 && i==j)
        {
            ans.add(sub);
            return;
        }
        
        visited[i][j]=1;
        if (isSafe(i, j + 1, mat, visited,n)) //right
        {
            solve(i, j + 1, mat, ans, sub + "R", visited);
        }
        if (isSafe(i+1, j, mat, visited,n)) //down
        {
            solve(i+1, j, mat, ans, sub + "D", visited);
        }
        if (isSafe(i, j -1, mat, visited,n)) //left
        {
            solve(i, j - 1, mat, ans, sub + "L", visited);
        }if (isSafe(i-1, j, mat, visited,n)) //up
        {
            solve(i-1, j, mat, ans, sub + "U", visited);
        }
        visited[i][j] = 0;
    }
    public boolean isSafe(int i, int j, int mat[][], int visited[][], int n)
    {
        return (i>=0 && j>=0 && i<n && j<n && visited[i][j]==0 && mat[i][j] == 1);
    }
}