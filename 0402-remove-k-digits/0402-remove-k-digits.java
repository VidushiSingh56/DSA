class Solution {
    public String removeKdigits(String num, int k) 
    {
        int n = num.length();
        if(n==k)
        return "0";
        Stack<Character> st = new Stack<>();
        String s = "";
        for(int i = 0;i< n;i++)
        {
            while(!st.isEmpty() && k>0 && st.peek()-'0'>num.charAt(i)-'0')
            {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(!st.isEmpty() && k!=0)
        {
            st.pop();
            k--;
        }
        while(!st.isEmpty())
        {
            s = s+st.pop();
        }
        return reverse(s);
    }
    public String reverse(String s)
    {
        String st = "";
        for(int i = s.length()-1;i>=0;i--)
        {
            st = st+s.charAt(i);
        }
        int i =0;
        System.out.print(st + " ");
        while(st.length()>1 && st.charAt(i) == '0')
        {
            st = st.substring(i+1, st.length());
             System.out.print(st + " ");
            i=0;
        }
        return st;
    }
}