class Solution {
    public int minAddToMakeValid(String s) 
    {
        int sum =0;
        int ans=0;
        int open =0,close =0;
        sum = s.charAt(0)=='(' ? 1 : -1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i) == '(' && s.charAt(i-1) == ')')
            {
                ans=(sum>=0)? ans : ans+(int)Math.abs(sum)  ;
                sum = sum>0 ? sum : 0;
            }
            if(s.charAt(i) == '(')
            sum+=1;
            else
            sum-=1;
        }
        ans =ans + (int)Math.abs(sum);
        return ans;
    }
}