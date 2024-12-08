class Solution 
{
    public int maximumGain(String s, int x, int y) 
    {
        int points = 0;
        
        // First pass: Try to remove 'ba' pairs and gain points for y
        StringBuilder sb = new StringBuilder(s);
        if(y>=x)
        {
            points = findba(sb, y);
            points += findab(sb, x);
        }
            
        else
        {
            points = findab(sb, x);
            points += findba(sb, y);
        }
        return points;
    }
    public int findba(StringBuilder sb, int y)
    {
        int points = 0;
        int i = 0;
        while (i < sb.length() - 1 && i>=0) 
        {
            if (sb.charAt(i) == 'b' && sb.charAt(i + 1) == 'a') {
                System.out.println(i+""+(i+1)+"k ");
                
                sb.delete(i, i + 2);  // Remove 'ba' pair
                if (i > 0) {
                    i--;
                }

                
                points += y;
                System.out.println("Hello"+points);
                // Don't increment i, check the new character after deletion
            } else {
                i++;
            }
        }
        return points;
    }
    public int findab(StringBuilder sb, int x)
    {
        int i = 0;
        int points = 0;
        while (i < sb.length() - 1 && i>=0) {
            if (sb.charAt(i) == 'a' && sb.charAt(i + 1) == 'b') {
                System.out.println(i+""+(i+1)+"kk ");
                sb.delete(i, i + 2);  // Remove 'ab' pair
                points += x;
                System.out.println("Helloss"+points);
                if (i > 0) {
                    i--;
                }

                // Don't increment i, check the new character after deletion
            } else {
                i++;
            }
        }
        return points;
    }
}
