class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int max = 0;
        for (int i : quantities)
            max = Math.max(i, max);

        // for (int x = max; x >= 1; x--) {
        //     if (ifpossible(x, quantities, n))
        //         continue;

            
        //     return x + 1;
        // }

        int low = 1, high = max;
        while(low <= high)
        {
            int mid = low + (high-low)/2;

            if(ifpossible(mid, quantities, n))
            high = mid-1;

            else
            low = mid+1;

        }
        return high+1;
    }

    public boolean ifpossible(int x, int[] quantities, int n) {
        int stores = 0;
        for (int i : quantities) {
            stores += (int) Math.ceil((double) i / x);
        }

        return stores <= n;
    }
}
