class Solution {
    public String removeOuterParentheses(String s) 
    {
        int n = s.length();
        List<String> list = new ArrayList<>();
        int open = 0, close = 0;
        int from = 0;
        for(int i = 0;i<n-1;i++)
        {
            char ch = s.charAt(i);
            char ch1 = s.charAt(i+1);
            if(ch == '(')
            open++;

            else
            close++;

            if(open == close && ch == ')' && ch1 == '(')
            {
                list.add(s.substring(from, i+1));
                System.out.println(s.substring(from, i+1)+"lll");
                open = 0;
                close = 0;
                from = i+1;
            }
        }
        if(s.charAt(n-1)==')')
        {
            close++;
        }
         if(open == close)
        {
            list.add(s.substring(from));
            System.out.println(s.substring(from)+"lll");
        }
        String ans = "";
        for(String i : list)
        {
            int nn = i.length();
            ans = ans + i.substring(1,nn-1);
        }
        return ans;
    }
}