class MyQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    int t1,t2;
    public MyQueue() 
    {
        t1=-1;
        t2=-1;
    }
    
    public void push(int x) 
    {
        if(t1 == -1 && t2 == -1)
        {
            t1++;
            s1.push(x);
        }
        else
        {
            while(t1>-1)
            {
                t2++;
                s2.push(s1.pop());
                t1--;
            }
            t1++;
            s1.push(x);
            while(t2>-1)
            {
                t1++;
                s1.push(s2.pop());
                t2--;
            }
        }
    }
    
    public int pop() 
    {
        if(t1 == -1 && t2 == -1)
        return -1;

        int ans = s1.pop();
        t1--;
        return ans;
    }
    
    public int peek() {
        if(t1 == -1 && t2 == -1)
        return -1;

        return s1.peek();
    }
    
    public boolean empty() 
    {
        if(t1 == -1 && t2 == -1)
        return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */