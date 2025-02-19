class Solution {
    public String getHappyString(int n, int k) 
    {
        List<String> happyString = new ArrayList<>();

        String currentString = "";
        getHappy(currentString, n, k, happyString);
        String s = "";
        if(happyString.size()<k)
        return "";
        Collections.sort(happyString);
        return happyString.get(k-1);
    }
    public void getHappy(String cur, int n, int k, List<String> happy)
    {
        if(cur.length() == n)
        {
            happy.add(cur);
            return;
        }


        for(char i = 'a'; i<='c';i++)
        {
            if(cur.length()>0 && cur.charAt(cur.length()-1) == i)
            {
                continue;
            }

            getHappy(cur+i, n, k, happy);
        }
    }
}