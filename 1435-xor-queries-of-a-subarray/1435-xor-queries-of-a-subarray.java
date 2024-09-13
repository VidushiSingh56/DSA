class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) 
    {
        int n = arr.length;
       
        // for(int i = 0; i<n;i++)
        // {
        //     int left = queries[i][0];
        //     int right = queries[i][1];
        //     int xor = 0;
        //     while(left<=right)
        //     {
        //         xor = xor ^ arr[left];
        //         left++;
        //     }
        //     ans[i] = xor;
        // }
        int N = queries.length;
        int[] pre = new int[n];
         int ans[]=new int[N];
        pre[0] = arr[0];
        for(int i=1;i<n;i++)
        {
            pre[i] = pre[i-1] ^ arr[i];
        }
        for(int i =0;i<N;i++)
        {
            int left = queries[i][0];
            int right = queries[i][1];
            if(left == 0)
            ans[i] = pre[right];
            else
            ans[i] = pre[right] ^ pre[left-1];
        }


        return ans;
    }
}