class Solution {
    public int maxCount(int[] banned, int n, int maxSum) 
    {
        //Brute
        // List<Integer> list = new ArrayList<>();
        // for(int i = 1;i<=n;i++)
        // {
        //     list.add(i);
        // }
        // for(int i = 0;i<banned.length;i++)
        // {
        //     if(banned[i]<=n)
        //     list.remove(Integer.valueOf(banned[i]));
        // }
        // int sum = list.get(0),i=1,count=0;
        // int len = list.size();
        // while(sum <= maxSum && i<len)
        // {
        //     count++;
        //     sum += list.get(i);
        //     i++;
            
        // }
        // if(sum<=maxSum)
        // count++;
        // // int count= 0;
        // return count; 

        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<banned.length;i++)
        {
            if(banned[i]<=n)
            set.add(banned[i]);
        }
        int sum = 0, count = 0;
        for(int i = 1;i<=n;i++)
        {
            if(!set.contains(i))
            {
                sum += i;
                count += sum<=maxSum ? 1 : 0;
            }
        }
        return count;
    }
}