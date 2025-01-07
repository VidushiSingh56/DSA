class Solution 
{
    public List<String> stringMatching(String[] words) 
    {
        int n = words.length;
        List<String> list = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            // String s = words[i];
            for(int j = 0;j<n;j++)
            {
                // String p = words[j];
                if(i != j)
                {
                    if(words[i].contains(words[j]) && !list.contains(words[j]))
                    list.add(words[j]);
                }
            }
        }
        return list;
    }
}