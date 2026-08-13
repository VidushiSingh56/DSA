class NumArray {

    int nums[];
    int tree[];
    public NumArray(int[] nums) 
    {
        this.nums = nums;
        tree = new int[4*nums.length];
        build(0, 0, nums.length-1);
    }

    public void build(int curnode, int low, int high)
    {
        if(low == high)
        {
            tree[curnode] = nums[low];
            return;
        }

        int leftchild = 2 * curnode + 1;
        int rightchild = 2 * curnode + 2;

        int mid = (low + high) / 2;
        build(leftchild, low, mid);
        build(rightchild, mid+1, high);

        tree[curnode] = tree[leftchild] + tree[rightchild];
    }
    

    public void update(int index, int val) 
    {
        nums[index] = val;

        updateTree(index, 0, 0, nums.length-1);
    }

    public void updateTree(int index, int curSegIndex, int l, int r)
    {
        if(l == r)
        {
            tree[curSegIndex] = nums[index];
            return;
        }

        int mid = (l + r) / 2;
        int leftchild = 2 * curSegIndex + 1;
        int rightchild = 2 * curSegIndex + 2;
        if(index <= mid)
        {
            updateTree(index, leftchild, l, mid);
        }
        else
        {
            updateTree(index, rightchild, mid+1, r);
        }

        tree[curSegIndex] = tree[leftchild] + tree[rightchild];
    }
    
    public int sumRange(int left, int right) 
    {
        int answer = sum(left, right, 0, nums.length-1, 0);
        return answer;
    }

    public int sum(int left, int right, int l, int r, int cur)
    {
        // if entirely inside range = don't explore
        // if entirely outside range = you don't care about that branch
        // if overlap = both places

        if(left<=l && right>=r)
        return tree[cur];

        if(left > r || right < l)
        return 0;

        int mid = (l+r)/2;
        int leftchild = sum(left, right, l, mid, 2*cur + 1);
        int rightchild = sum(left, right, mid+1, r, 2*cur + 2);

        return leftchild + rightchild;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */