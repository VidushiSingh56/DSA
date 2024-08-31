class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;

        long N = n;
        if (N < 0) {
            x = 1 / x;  
            N = -N;     
        }

        return powRecursive(x, N);
    }

    private double powRecursive(double x, long n) {
        if (n == 0) return 1.0;
        double half = powRecursive(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } 
        else {
            return half * half * x;
        }
    }
}
