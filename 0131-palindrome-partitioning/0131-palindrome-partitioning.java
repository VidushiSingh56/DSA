class Solution {
    public List<List<String>> partition(String s) 
    {
        List<List<String>> ans = new ArrayList<>();
        List<String> sub = new ArrayList<>();
        gett(s, sub, ans, 0);
        return ans;
    }
    public void gett(String s, List<String> sub, List<List<String>> ans, int i)
    {
        if(i == s.length())
        {
            ans.add(new ArrayList(sub));
            return;
        }
        int j;
        for(j=i+1; j<=s.length();j++)
        {
            String str = s.substring(i,j);
            if(check(str))
            {
                sub.add(str);
                gett(s, sub, ans, j);
                sub.remove(sub.size()-1);
            }
           
        }
    }
    public boolean check(String s)
    {
        String rev = new StringBuffer(s).reverse().toString();
        if(rev.equals(s))
        return true;

        return false;
    }
}