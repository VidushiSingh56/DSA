class Solution {
    public String countAndSay(int n) 
    {
        if(n == 1)
        return "1";
        
        String j = countAndSay(n-1);
        String st = "";
        int count=1;
        int i;
        for(i=0;i<j.length()-1;i++)
        {
            if(j.charAt(i)==j.charAt(i+1))
            {
                count++;
            }
            else{
                String temp =  String.valueOf(count);
                st=st+temp+j.charAt(i);
                count=1;
            }
        }
        String temp =  String.valueOf(count);
        st=st+temp+j.charAt(i);
        return st;
    }
}