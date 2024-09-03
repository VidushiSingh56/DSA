class Solution {
    private Map<Integer, String> letters = Map.of(
        2, "abc", 3, "def", 4, "ghi", 5, "jkl", 
        6, "mno", 7, "pqrs", 8, "tuv", 9, "wxyz");
    public List<String> letterCombinations(String digits) 
    {
        
        List<String> ans = new ArrayList<>();
       StringBuilder sub = new StringBuilder();
        find(digits, 0, ans, sub);
        return ans;
    }
    public void find(String digits, int i,  List<String> ans, StringBuilder sub)
    {
        if(digits.length()==0)
        return;

        if (sub.length() == digits.length()) {
            ans.add(sub.toString());
            return;
        }


        Character c = digits.charAt(i);
        String letter = letters.get(c - '0');
        for (int j = 0; j < letter.length(); j ++) {
            sub.append(letter.charAt(j));
            find(digits, i + 1 ,ans, sub);
            sub.deleteCharAt(sub.length() -  1);
        }
    }
}