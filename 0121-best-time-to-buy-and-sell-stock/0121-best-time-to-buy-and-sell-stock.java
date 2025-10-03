class Solution 
{
    public int maxProfit(int[] prices) 
    {
        
        //We can maintain a minimum from the start of the array and compare it with every element of the array, ifit is greater than the minimum then take the difference and maintain it in max, otherwise update the minimum.

        int min=Integer.MAX_VALUE, maxprofit = 0;
        for(int i = 0;i<prices.length;i++)
        {
            if(min >= prices[i])
            {
                min = prices[i];
                continue;
            }
            
            maxprofit = Math.max(maxprofit, prices[i]-min);
        }

        return maxprofit;
    }
}