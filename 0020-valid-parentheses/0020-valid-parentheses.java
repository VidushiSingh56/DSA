class Solution {
    public boolean isValid(String s) 
    {
        int n= s.length();
        Stack<Character> stack = new Stack<>();
        stack.push('0');
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
            {
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')' && stack.peek() == '(')
            {
                stack.pop();
            }
            else if(s.charAt(i) == '}' && stack.peek() == '{')
            {
                stack.pop();
            }
            else if(s.charAt(i) == ']' && stack.peek() == '[')
            {
                stack.pop();
            }
            else
            return false;
        }
        if(stack.peek()=='0')
        return true;
        return false;
    }
}