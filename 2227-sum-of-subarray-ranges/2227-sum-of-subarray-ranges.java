class Solution {
    public long subArrayRanges(int[] nums) 
    {
        int n = nums.length;
        long lSum=0, sSum =0;
        // for(int i = 0;i<n;i++)
        // {
        //     lSum = lSum + maximumsum(nums, i);
        //     sSum = sSum + minimumsum(nums,i);
        // }
        lSum = maximumsum(nums);
        sSum = minimumsum(nums);
        return lSum-sSum;
    }
    public long maximumsum(int[] nums)
    {
        // int mod = 1000000007;
        int n= nums.length;
        int nge[] = new int[n];
        int pge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        long sum=0, sub=0;
        for(int i = 0;i<n;i++)
        {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i])
            st.pop();

            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = n-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[st.peek()] < nums[i])
            st.pop();

            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        
        for(int i =0;i<n;i++)
        {
            int leftRange = i - pge[i];   
            int rightRange = nge[i] - i;  
            
            long subarrayCount =  leftRange * rightRange;
            sum = sum + (subarrayCount * nums[i]) ;
        }
        return sum;
    }
    public long minimumsum(int[] nums)
    {
        // int mod = 1000000007;
        int n= nums.length;
        int nse[] = new int[n];
        int pse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        long sum=0, sub=0;
        for(int i = 0;i<n;i++)
        {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i])
            st.pop();

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = n-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[st.peek()] > nums[i])
            st.pop();

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        
        for(int i =0;i<n;i++)
        {
            int leftRange = i - pse[i];   
            int rightRange = nse[i] - i;  
            
            long subarrayCount = leftRange * rightRange;
            sum = sum + (subarrayCount * nums[i]) ;
        }
        return sum;
    }

}