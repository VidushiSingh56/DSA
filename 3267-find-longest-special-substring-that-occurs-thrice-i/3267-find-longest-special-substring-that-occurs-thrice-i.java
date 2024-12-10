import java.util.HashMap;

class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid, s)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            System.out.println(check(mid,s) + "" +mid);
        }

        if(high == 0)
        return -1;

        return high;
    }

    public boolean check(int times, String s) 
    {
        HashMap<String, Integer> count = new HashMap<>();

        // Ensure no out-of-bounds substring
        for (int i = 0; i <= s.length() - times; i++) 
        {
             String substring = s.substring(i, i + times);

            // Check if the substring is special (all characters are the same)
            if (isSpecial(substring)) 
            {
                count.put(substring, count.getOrDefault(substring, 0) + 1);

                // If any special substring occurs at least 3 times
                if (count.get(substring) >= 3) 
                {
                    System.out.print(" " + substring + "k");
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isSpecial(String substring) 
    {
        char firstChar = substring.charAt(0);
        for (int j = 1; j < substring.length(); j++) 
        {
            if (substring.charAt(j) != firstChar) 
            {
                return false;
            }
        }
        return true;
    }
}
