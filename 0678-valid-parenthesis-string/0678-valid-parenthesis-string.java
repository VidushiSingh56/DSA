class Solution
{
    public boolean checkValidString(String s) 
    {
        //you are missing out certain cases;
        //good try can present in interview
        // int lastseenopen=-1;
        // int lastseenstar=-1;
        // int count=0,n=s.length(),star=0;
        // for(int i=0;i<n;i++)
        // {
        //     char ch = s.charAt(i);
        //     if(ch == '(')
        //     {
        //         lastseenopen=i;
        //         count++;
        //     }
        //     else if(ch == ')')
        //     {
        //         count--;
        //     }
        //     else
        //     {
        //         lastseenstar=i;
        //         star++;
        //     }

        //     if(count < 0)
        //     {
        //         if(star > 0)
        //         {
        //             star--;
        //             count++;
        //         }
        //         else
        //         return false;
        //     }
        // }

        

        // if(count == 0)
        // return true;

        // if(count > 0 && count <= star && lastseenopen < lastseenstar)
        // {
        //     return true;
        // }
        // return false;

        //next solution where you maintain a range
         int minOpen = 0, maxOpen = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                minOpen++;
                maxOpen++;
            } else if (ch == ')') {
                minOpen = Math.max(minOpen - 1, 0);
                maxOpen--;
            } else { // '*'
                minOpen = Math.max(minOpen - 1, 0);
                maxOpen++;
            }

            if (maxOpen < 0) return false; // too many ')' → cannot fix
        }
        return minOpen == 0;
    }
}