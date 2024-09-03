class Solution {
    public List<String> letterCombinations(String digits) 
    {
        char st[][] = {{},{},{'a','b','c'},{'d','e','f'},
                        {'g','h','i'},{'j','k','l'},{'m','n','o'},
                        {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        List<String> ans = new ArrayList<>();
        String sub = "";
        find(digits, 0, st, ans, sub);
        return ans;
    }
    public void find(String digits, int i, char st[][], List<String> ans, String sub)
    {
        if(digits.length()==0)
        return;

        if(i==digits.length())
        {
            ans.add(sub);
            return;
        }
        for(int x=0;x<4;x++)
        {
            if(digits.charAt(i) != '7' && digits.charAt(i) != '9' && x==3)
            break;

            

            int a=Integer.parseInt(String.valueOf(digits.charAt(i))); 
            sub=sub+(st[a][x]);
            find(digits, i+1, st, ans, sub);
            sub = sub.substring(0,sub.length()-1);
        }
        
    }
}