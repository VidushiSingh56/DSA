class Solution {
    public int numberOfSubstrings(String s) 
    {
        int hash[] = {-1, -1, -1};
        int count=0;
        int n = s.length();
        
        for(int i = 0;i<n;i++)
        {
            char ch= s.charAt(i);
            hash[ch-'a'] = i;
            if(hash[0] != -1 && hash[1]!=-1 && hash[2] !=-1)
            {
                int temp = Math.min(hash[0], hash[1]);
                count += 1+ (Math.min(hash[2], temp));
            } 
        } 

        
        return count;
    }
}