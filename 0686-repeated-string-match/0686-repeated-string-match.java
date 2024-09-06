class Solution {
    public int repeatedStringMatch(String a, String b) 
    {
        int i =0;
        while(i<a.length())
        {
            if(a.charAt(i) == b.charAt(0))
            {
                System.out.print("hello"+i);
                int ans = match(a,b,i);
                // System.out.print(ans);
                if(ans != -1)
                return ans;
            }
            i++;
        } 
        return -1;  
    }
    public int match(String a, String b, int i)
    {
        int count=1;
        int j=0;int n= a.length();
        while(j<b.length())
        {
            if(a.charAt(i%n) != b.charAt(j))
            {
                return -1;
            }
            if(i%n==0 && i!=0)
            {
                count++;
            }
            j++;i++;
        }
        
        return count;
    }
}