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

        List<String> numbers = new ArrayList<>();
        String current = "";
        generate(numbers, n, current);
        String ans = "";
        for(String i : numbers)
        {
            if(!list.contains(i))
            {
                ans = i;
                break;
            }
        }
        return ans;
    }
    public void generate(List<String> numbers, int n, String cur)
    {
        if(cur.length() == n)
        {
            numbers.add(cur);
            return;
        }

        for(int i = 0;i<=1;i++)
        {
            char a = Character.forDigit(i, 10);

            generate(numbers, n, cur+a);
        } 
    }
}
