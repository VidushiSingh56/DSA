class Solution {
    public int[] nextGreaterElements(int[] nums)
    {
        int n = nums.length;
        int ar[]=new int[2*n];
        int h[]=new int[2*n];
        for(int i =0;i<2*n;i++)
        {
            ar[i] = nums[i%n];
        }
        Stack<Integer> stack = new Stack <>();
        for(int i=(2*n)-1;i>=0;i--)
        {
            if(stack.isEmpty())
            {
                h[i]=-1;
                stack.push(ar[i]);
            }
            else if(!stack.isEmpty() && stack.peek()>ar[i])
            {
                h[i]=stack.peek();
                stack.push(ar[i]);
            }
            else
            {
                while(!stack.isEmpty() && stack.peek()<=ar[i])
                {
                    stack.pop();
                }
                if(stack.isEmpty())
                {
                    h[i]=-1;
                    stack.push(ar[i]);continue;
                }
                h[i]=stack.peek();
                stack.push(ar[i]);
            }
        }
        int ans[]=new int[n];
        for(int i =0;i<n;i++)
        {
            ans[i]=h[i];
        }
        return ans;
    }
}