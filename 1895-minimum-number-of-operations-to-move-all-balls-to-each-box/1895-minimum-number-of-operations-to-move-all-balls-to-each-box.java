class Solution 
{
    public int[] minOperations(String boxes) 
    {
        int n = boxes.length();
        int ans[] = new int[n];
        int count = 0;
        for(int i = 1;i<n;i++)
        {
            char ch = boxes.charAt(i);
            if(ch == '1')
            {
                count++;
                ans[0] += i-0;
            }
        }

        int rightsum = ans[0], leftsum = 0, leftcount = 0, rightcount = count;
        for(int i = 1;i<n;i++)
        {
            char ch = boxes.charAt(i);
            char ch1 = boxes.charAt(i-1);
            
            rightsum = rightsum - rightcount;
            leftsum = leftsum + leftcount + ((ch1 == '1') ? 1 : 0);
            rightcount = (ch == '1') ? rightcount - 1 : rightcount;
            leftcount = leftcount + ((ch1 == '1') ? 1 : 0);
            ans[i] = rightsum + leftsum;
            
        }
        return ans;
    }
}