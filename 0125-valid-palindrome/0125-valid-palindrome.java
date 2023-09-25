class Solution 
{
    public boolean isPalindrome(String s) 
    {
        if(s==" ")
        {
            return true;
            
        }
        else
        {
            s=s.toLowerCase();
            char ch=' ';
		    String st="";
		    int h=s.length();
            for(int i=0;i<h;i++)
            {
                ch=s.charAt(i);
                if(!(Character.isAlphabetic(ch)) && !(Character.isDigit(ch)))
		        {
		           continue;
		        }
		        else{
		            st=st+ch;
		        }
            }

            String star=reversed(st, st.length()-1,"");
            return(star.equals(st));
        }
    }
    public String reversed(String st, int k, String j)
    {
        if(k<0)
        {
            return j;
        }
        j=j+st.charAt(k);
        return reversed(st, k-1, j);
    }
}