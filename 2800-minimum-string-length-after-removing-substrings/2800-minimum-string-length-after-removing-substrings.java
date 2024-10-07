class Solution {
    public int minLength(String s) 
    {
        String s1 = "AB", s2="CD";
        int i =0,j=2;
        while(j<=s.length())
        {
            String demo = s.substring(i,j);
            if(s1.equals(demo) || s2.equals(demo))
            {
                s = s.substring(0,i)+s.substring(j); 
                System.out.print(s+"p ");
                i=0;
                j=2;
                continue;
            }
            i++;j++;
        }
        return s.length();
    }
}