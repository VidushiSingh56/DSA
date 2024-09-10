//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) 
     {
        // Your code here
        Stack<Character> st = new Stack<>();
        String s="";
        int i=0;
        while(i<exp.length())
        {
            char c = exp.charAt(i);
            if((c>='a' && c<='z') || (c>='A' && c<='Z') || c>='0' && c<='9')
            {
                s=s+c;
            }
            else if(c=='(')
            {
                st.push('(');
            }
            else if(c==')')
            {
                while(st.peek()!='(')
                {
                    s=s+st.peek();
                    st.pop();
                }
                st.pop();
            }
            else
            {
                while(!st.isEmpty() && priority(c)<=priority(st.peek()))
                {
                    s=s+st.peek();
                    st.pop();
                }
                st.push(c);
            }
            i++;
        }
        while(!st.isEmpty())
        {
            s=s+st.peek();
            st.pop();
        }
        return s;
    }
    public static int priority(char c)
    {
        if(c=='^')
        return 3;
        else if(c=='*' || c=='/')
        return 2;
        else if(c=='+' || c=='-')
        return 1;
        return -1;
    }
}