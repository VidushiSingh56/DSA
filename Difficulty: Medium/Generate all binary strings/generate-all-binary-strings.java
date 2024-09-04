//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static List<String> generateBinaryStrings(int n) 
  {
    // code here
        List<String> ans = new ArrayList<>();
        String s1="0";
        fun(s1,n-1, ans);
        String s2="1";
        fun(s2,n-1, ans);
        return ans;
        
  }
  public static void fun(String s, int n, List<String> ans)
  {
        if(n==0)
        {
            ans.add(s);
            return;
        }
        int x= s.length();
        char a = s.charAt(x-1);
        char b = '1';
        if(a==b)
        {
            String s1 = s;
            s1 = s1+"0";
            fun(s1, n-1, ans);
        }
        else
        {
            String s1 = s;
            String s2 = s;
            s1 = s1+"0";
            s2 = s2+"1";
            fun(s1,n-1,ans);
            fun(s2,n-1,ans);
        }
  }
}
     
     