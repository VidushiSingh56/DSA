class Solution {
    public int[] nextGreaterElements(int[] nums)
    {
        int n = nums.length;
        int h[]=new int[n];
        Stack<Integer> stack = new Stack <>();
        for(int i=2*n-1;i>=0;i--)
        {

            // if(stack.isEmpty())
            // {
            //     // h[i]=-1;
            //     stack.push(nums[i%n]);
            // }
            // else if(!stack.isEmpty() && stack.peek()>nums[i%n])
            // {
            //     if(i<n)
            //     h[i] = stack.peek();
            //     stack.push(nums[i%n]);
            // }
            // else
            // {
            //     while(!stack.isEmpty() && stack.peek()<=nums[i%n])
            //     {
            //         stack.pop();
            //     }
            //     if(stack.isEmpty())
            //     {
            //         if(i<n)
            //         h[i]=-1;
            //         // h[i]=(i<n) ? -1 : h[i];
            //         stack.push(nums[i%n]);continue;
            //     }
            //     if(i<n)
            //     h[i] = stack.peek();
            //     stack.push(nums[i%n]);
            // }
                while(!stack.isEmpty() && stack.peek()<=nums[i%n])
                {
                    stack.pop();
                }
                if(i<n)
                {
                    h[i] = stack.isEmpty() ? -1 : stack.peek();
                }
                stack.push(nums[i%n]);
        }
        return h;
    }    
}