class Solution {
    public List<String> generateParenthesis(int n) 
    {
        List<String> ans = new ArrayList<>();
        String sub="";
        gen(0, 0, sub, ans, n);
        return ans;
        
    }
    public void gen(int o, int c, String sub, List<String> ans,int n)
    {
        if(o==n && c==n)
        {
            
                ans.add(sub);
            return;
            
            
            
        }
        if (o < n) {
            gen(o + 1, c, sub + '(', ans, n);
        }

        if (c < o) {
            gen(o, c + 1, sub + ')', ans, n);
        }


    }
}