class Solution 
{
    public String longestPalindrome(String s) 
    {
        if(s.length() <= 1)
        return s;
        int n = s.length();
        
        String ans = s.substring(0,1);
        for(int i = 0;i<n-1;i++)
        {    //babad
            
            String odd = takeOutFromCentre(s,i,i);
            System.out.print(odd+"");
            String even = takeOutFromCentre(s,i,i+1);
            // System.out.print(odd + "" + even+ "");
            // System.out.println();
            if(odd.length() > ans.length())
            {
                ans = odd;
            }
            
            if(even.length() > ans.length())
            {
                ans = even;
            }
        }
       return ans;
    }
    public String takeOutFromCentre(String s, int left, int right)
    {
        while(left >=0 && right<s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}

