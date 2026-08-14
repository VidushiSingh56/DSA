class Solution {
    public int minOperations(int k) {
        int ans = Integer.MAX_VALUE;

        for (int x = 1; x <= k; x++) {
            int operations = (x - 1) + (int)Math.ceil((double) k / x) - 1;
            ans = Math.min(ans, operations);
        }

        return ans;
    }
}