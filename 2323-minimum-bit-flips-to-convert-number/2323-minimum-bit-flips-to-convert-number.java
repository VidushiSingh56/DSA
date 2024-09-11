class Solution {
    public int minBitFlips(int start, int goal) 
    {
        String start1 = start == 0 ? "0" : convert(start);
        String goal1 = goal == 0 ? "0" : convert(goal);
        System.out.print(start1+ ""+goal1);
        int j = goal1.length()-1,i=start1.length()-1;
        int count=0;
        while(i>=0 && j>=0)
        {
            if(start1.charAt(i) != goal1.charAt(j))
            {
                count++;
            }
            i--;j--;
        }
        while(i>=0)
        {
            if(start1.charAt(i) == '1')
            count++;
            i--;
        }
        while(j>=0)
        {
            if(goal1.charAt(j) == '1')
            count++;
            j--;
        }
        return count;
    }
    
    
    
    public String convert(int n)
    {
        if (n == 0) {
            return "";  
        } else {
            
            return convert(n / 2) + (n % 2);
        }
    }
}