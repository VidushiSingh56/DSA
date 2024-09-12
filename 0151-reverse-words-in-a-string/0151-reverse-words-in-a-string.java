class Solution {
    public String reverseWords(String s) 
    {
        
        s = s.trim();
        int n = s.length();
        System.out.println(s);
        int i = n-1;
        int j = n;
        String ans = "";
        while(i>=0)
        {
            char ch = s.charAt(i);

            if(ch == ' ' && s.charAt(i-1) != ' ')
            {
                ans = ans + (s.substring(i+1,j)).trim()+ " ";
                j=i;
            }
            i--;
        }
        ans = ans + s.substring(i+1,j);
        return ans.trim();
    }
}