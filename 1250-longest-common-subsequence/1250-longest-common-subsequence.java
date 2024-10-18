class Solution {
    public int longestCommonSubsequence(String text1, String text2) 
    {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        for(int row[] : dp)
        {
            Arrays.fill(row, -1);
        }
        return lcs(text1, text2, text1.length(), text2.length(), dp);


        // for(int i= 0;i<m;i++)
        // {

        // }

    }
    public int lcs(String s , String t, int m , int n, int[][] dp)
    {
        if(m==0 || n==0)
        return 0;

        if(dp[m][n] != -1)
        return dp[m][n];

        if(s.charAt(m-1) == t.charAt(n-1))
        {
            dp[m][n] = 1+lcs(s,t,m-1,n-1,dp);
            return dp[m][n];
        }

        dp[m][n] = Math.max(lcs(s,t,m,n-1,dp), lcs(s,t,m-1,n,dp));
        return dp[m][n];
    }
}