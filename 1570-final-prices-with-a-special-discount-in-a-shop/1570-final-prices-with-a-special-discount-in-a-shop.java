class Solution 
{
    public int[] finalPrices(int[] prices) 
    {
        int n = prices.length;
        Stack<Integer> stack = new Stack<>();
        int ar[] = new int[n];
        ar[n-1] =prices[n-1];
        stack.push(ar[n-1]);
        int i = n-2;
        while(!stack.isEmpty() && i>=0)
        {
            while(!stack.isEmpty() && prices[i] < stack.peek())
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                stack.push(prices[i]);
                ar[i] = prices[i];
                i--;
                continue;
            }
            if(prices[i]>=stack.peek())
            {
                ar[i] = prices[i] - stack.peek();
                stack.push(prices[i]);
            }
            i--;    
        }
        return ar;
    }
}