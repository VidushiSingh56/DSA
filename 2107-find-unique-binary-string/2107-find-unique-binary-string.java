class Solution 
{
    public String findDifferentBinaryString(String[] nums) 
    {
        int n = nums.length;
        List<String> list = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            list.add(nums[i]);
        }

        // List<String> numbers = new ArrayList<>();
        String current = "";
        return generate(n, current, list);
        
        // for(String i : numbers)
        // {
        //     if(!list.contains(i))
        //     {
        //         ans = i;
        //         break;
        //     }
        // }
       
    }
    public String generate(int n, String cur, List<String> list)
    {
        if(cur.length() == n)
        {
            if(!list.contains(cur))
            return cur;

            else
            return "";
        }
        String s="";
        for(int i = 0;i<=1;i++)
        {
            char a = Character.forDigit(i, 10);

            s = generate(n, cur+a, list);
            if(!s.equals(""))
            break;
        } 
        return s;
    }
}
