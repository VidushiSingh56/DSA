class Solution 
{
    int getLPSLength(String s) 
    {
        int n = s.length();
        if (n == 1)
            return 0;

        int prefix = 0, suffix = 1;
        int arr[] = new int[n];
        arr[0] = 0;

        while (suffix < n)
        {
            if (s.charAt(prefix) == s.charAt(suffix))
            {
                prefix++;
                arr[suffix] = prefix;
                suffix++;
            }
            else
            {
                if (prefix != 0)
                {
                    prefix = arr[prefix - 1];
                }
                else
                {
                    arr[suffix] = 0;
                    suffix++;
                }
            }
        }

        return arr[n - 1];
    }
}
