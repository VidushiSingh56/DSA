class Solution 
{
    public String minWindow(String s, String t) 
    {
        int left = 0, right = 0, m = s.length(), n = t.length(), count = 0, len=Integer.MAX_VALUE;
        if(m < n)
        return "";
        String strings="";
        int hash[] = new int[256];
        for(int i =0;i<n;i++)
        {
            int h = t.charAt(i);
            hash[h]++;
        }
        while(right < m)
        {
            int r = (int)s.charAt(right);
            if(hash[r] > 0)
            {
                
                count++;
            }
            while(count == n)
            {
                if(len > right-left+1)
                {
                    strings = s.substring(left, right+1);
                    len = right-left+1;
                }
                int l = (int)s.charAt(left);
                hash[l]++;
                if(hash[l] > 0)
                {
                    count--;
                }
                left++;
            }
            hash[r]--;
            right++;
        }

        return strings;

    }
}