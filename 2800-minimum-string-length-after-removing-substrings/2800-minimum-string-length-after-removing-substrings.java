class Solution {
    public int minLength(String s) 
    {
        // String s1 = "AB", s2="CD";
        // int i =0,j=2;
        // while(j<=s.length())
        // {
        //     String demo = s.substring(i,j);
        //     if(s1.equals(demo) || s2.equals(demo))
        //     {
        //         s = s.substring(0,i)+s.substring(j); 
        //         System.out.print(s+"p ");
        //         i=0;
        //         j=2;
        //         continue;
        //     }
        //     i++;j++;
        // }
        // return s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
            boolean op = true;
            while (stack.size() > 1 && op) {
                char top = stack.pop();
                if (stack.peek() == 'A' && top == 'B') stack.pop();
                else if (stack.peek() == 'C' && top == 'D') stack.pop();
                else {
                    stack.push(top);
                    op = false;
                }
            }
        }
        return stack.size();
    }
}