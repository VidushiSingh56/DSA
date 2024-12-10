class Solution 
{
    public String convert(String s, int numRows) 
    {
        int m = numRows;
        if(m==1)
        return s;
        int length = s.length();
        int div = m+(m-2);
        int factor = length/div;
        int n = (factor*1) + (factor*(m-2));
        int rem = length % div;
        n += (rem/m)*1 + (rem%m);

        char arr[][] = new char[m][n]; //m=4
        int k = 0,j=0;int i;
        while(j<n && k<length)
        {
            for(i=0;i<m && k<length;i++)
            {
                arr[i][j] = s.charAt(k);
                k++;
            }
            i -= 2;
            j++;
            while(i>0 && j<n && k<length)
            {
                arr[i][j] = s.charAt(k);
                k++;
                j++;
                i--;
            }
        }
        String ans = "";

        for(i =0;i<m;i++)
        {
            for(j = 0;j<n;j++)
            {
                if(arr[i][j] != '\u0000')
                {
                    ans += arr[i][j];
                }
            }
        }
        return ans;
        
    }
}