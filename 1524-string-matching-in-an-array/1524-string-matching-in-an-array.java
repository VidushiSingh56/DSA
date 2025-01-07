class Solution 
{
    public List<String> stringMatching(String[] words) 
    {
        int n = words.length;
        List<String> list = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            String s = words[i];
            for(int j = 0;j<n;j++)
            {
                String p = words[j];
                if(i != j && s.length()>=p.length())
                {
                    if(s.contains(p) && !list.contains(p))
                    list.add(p);
                }
            }
        }
        return list;
    }
}