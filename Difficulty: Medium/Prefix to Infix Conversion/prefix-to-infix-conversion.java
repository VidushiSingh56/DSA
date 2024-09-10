//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToInfix(String pre_exp) 
    {
        // code here
        Stack<String> st = new Stack<>();
         
        String t1,t2;
        int i=pre_exp.length()-1;
        while(i>=0)
        {
            char c = pre_exp.charAt(i);
            if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'))
            {
                String ch = Character.toString(c);
                st.push(ch);
            }
            else 
            {
                t1=st.peek();st.pop();
                t2=st.peek();st.pop();
                String stri = "("+t1+c+t2+")";
                st.push(stri);
            }
            i--;
        }
        return st.peek();
    }
}
