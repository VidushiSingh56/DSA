class Solution {
    public boolean canMakeSubsequence(String str1, String str2) 
    {
        int n1 = str1.length();
        int n2 = str2.length();
        int i = n1-1, j = n2-1;
        while(i>=0 && j>=0)
        {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
            if(ch2 - ch1 == 1 || ch2 - ch1 == -25 || ch1 == ch2) 
            {
                i--;
                j--;
            }
            else
            {
                i--;
            }
        }
        if(j<0)
        return true;

        return false;
    }
}