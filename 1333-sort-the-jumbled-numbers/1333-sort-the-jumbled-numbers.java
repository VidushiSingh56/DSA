class Solution 
{
    public int[] sortJumbled(int[] mapping, int[] nums) 
    {
        int n = nums.length;
        int arr[] = new int[n];
        List<int[]> list = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            int nu = nums[i];
            int length = String.valueOf(nu).length();
            int div = (int)Math.pow(10, length-1);
            int result=0;
            while(div != 0)
            {
                int quo = nu/div;
                result = result*10 + mapping[quo];
                nu = nu % div;
                div = div/10;
            }
            list.add(new int[]{result, i});
            System.out.print(result+""+i+" ");
        }
         list.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Compare first elements
            } else {
                return Integer.compare(a[1], b[1]); // Compare second elements if first ones are equal
            }
        });

        // for(int pair[]:list)
        // {
        //     System.out.println(Arrays.toString(pair)+"k");
        // }
        int j =0;
        int res[] = new int[n];
        for(int i[] : list)
        {
            res[j++] = nums[i[1]];
            System.out.println(nums[i[1]]);
            
        }
        return res;
    }
}