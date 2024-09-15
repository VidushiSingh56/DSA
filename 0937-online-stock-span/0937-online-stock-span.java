class StockSpanner {

   Stack<int[]> s; 
   int index;
    public StockSpanner() 
    {
        s = new Stack<>();
        index =0;
    }
    
    public int next(int price) 
    {  
        
        while(!s.isEmpty() && price >= s.peek()[0])
        {
            s.pop();
        }
        int days = s.isEmpty() ? index - (-1) : index - s.peek()[1];
        s.push(new int[]{price, index});
        index = index+1;
        return days;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */