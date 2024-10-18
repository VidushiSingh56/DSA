class Solution {
    public int longestCommonSubsequence(String text1, String text2) 
    {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        // for(int row[] : dp)
        // {
        //     Arrays.fill(row, -1);
        // }
        // return lcs(text1, text2, text1.length(), text2.length(), dp);

        int m = text1.length();
        int n = text2.length();
        for(int i= 0;i<=m;i++)
        dp[i][0] = 0;
        for(int j = 0;j<=n;j++)
        dp[0][j] = 0;

        for(int i = 1;i<=m;i++)
        {
            for(int j = 1;j<=n;j++)
            {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    // public int lcs(String s , String t, int m , int n, int[][] dp)
    // {
    //     if(m==0 || n==0)
    //     return 0;

    //     if(dp[m][n] != -1)
    //     return dp[m][n];

    //     if(s.charAt(m-1) == t.charAt(n-1))
    //     {
    //         dp[m][n] = 1+lcs(s,t,m-1,n-1,dp);
    //         return dp[m][n];
    //     }

    //     dp[m][n] = Math.max(lcs(s,t,m,n-1,dp), lcs(s,t,m-1,n,dp));
    //     return dp[m][n];
    // }
}