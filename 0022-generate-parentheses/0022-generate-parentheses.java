class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sub = new StringBuilder();
        gen(0, 0, sub, ans, n);
        return ans;
    }

    public void gen(int o, int c, StringBuilder sub, List<String> ans, int n) {
        if (o == n && c == n) {
            ans.add(sub.toString());
            return;
        }
        
        if (o < n) {
            sub.append('(');
            gen(o + 1, c, sub, ans, n);
            sub.deleteCharAt(sub.length() - 1); // backtrack
        }
        
        if (c < o) {
            sub.append(')');
            gen(o, c + 1, sub, ans, n);
            sub.deleteCharAt(sub.length() - 1); // backtrack
        }
    }
}
