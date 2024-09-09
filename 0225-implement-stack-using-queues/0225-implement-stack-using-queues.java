class MyStack {
   Queue<Integer> que = new LinkedList<>();
    int front, rear;

    public MyStack() {
        front = 0;
        rear = 0;
    }
    
    public void push(int x) 
    {
        que.add(x);
        int r=rear;
        rear++;
        int flag=0;
        if(rear-front>=2)
        {
            while(front<r)
            {
                que.add(que.remove());
                front++;
                rear++;
                flag=1;
            }
        }
        // front = flag==1 ? front-1 : front;
        
    }
    
    public int pop() 
    {
        System.out.print(front + " "+ rear);
        if(front==rear)
        return -1;
        int ans = que.remove();
        
        front++;
        
        return ans;
       
    }
    
    public int top() 
    {
        if(front != rear)
        {System.out.println(que.peek()+" "+front);
        return que.peek();  }
        return -1; 
    }
    
    public boolean empty() 
    {
        
        if(front == rear)
        return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */