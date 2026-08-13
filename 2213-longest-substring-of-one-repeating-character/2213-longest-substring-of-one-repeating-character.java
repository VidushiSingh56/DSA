class Solution 
{
    class Node
    {
        int len, prefix, suffix, best; char leftC, rightC;
        public Node(int len, int prefix, int suffix, int best, char leftC, char rightC)
        {
            this.len = len;
            this.prefix = prefix;
            this.suffix = suffix;
            this.best = best;
            this.leftC = leftC;
            this.rightC = rightC;
        }
    }

    char sb[];
    Node segmenttree[];
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) 
    {
        sb = s.toCharArray();
        int n = s.length();
        int k = queryIndices.length;
        segmenttree = new Node[4 * n];

        build(0, 0, n-1);
        int ans[] = new int[k];
        for(int i = 0; i<k;i++)
        {
            char c = queryCharacters.charAt(i);
            int index = queryIndices[i];
            sb[index] = c;

            update(0, 0, n-1, index);

            ans[i] = segmenttree[0].best;
        }

        return ans;
    }

    public void update(int curnode, int l, int r, int index)
    {
        if(l == r)
        {
            Node node = new Node(1,1,1,1,sb[index], sb[index]);
            segmenttree[curnode] = node;
            return;
        }

        int leftchild = 2 * curnode + 1;
        int rightchild = 2 * curnode + 2;

        int mid = (l+r)/2;
        if(index <= mid)
        {
            update(leftchild, l, mid, index);
        }
        else
        {
            update(rightchild, mid+1, r, index);
        }

        segmenttree[curnode] = merge(segmenttree[leftchild], segmenttree[rightchild]);
    }

    public void build(int curnode,int l, int r)
    {
        if(l == r)
        {
            Node node = new Node(1,1,1,1,sb[l], sb[l]);
            segmenttree[curnode] = node;
            return;
        }

        int leftIndex = 2*curnode + 1;
        int rightIndex = 2*curnode + 2;

        int mid = (l + r)/2;
        build(leftIndex, l, mid);
        build(rightIndex, mid+1, r);

        segmenttree[curnode] = merge(segmenttree[leftIndex], segmenttree[rightIndex]);
    }

    public Node merge(Node left, Node right)
    {
        int len = left.len + right.len;

        int prefix = left.prefix;

        if(left.len == left.prefix && left.rightC == right.leftC)
        {
            prefix = left.len + right.prefix;
        }

        int suffix = right.suffix;

        if(right.len == right.suffix && left.rightC == right.leftC)
        {
            suffix = right.len + left.suffix;
        }

        int best = Math.max(left.best, right.best);

        if(right.leftC == left.rightC)
        {
            best = Math.max(best, right.prefix+left.suffix);
        }

        Node node = new Node(len, prefix, suffix, best, left.leftC, right.rightC);
        return node;
    }
}