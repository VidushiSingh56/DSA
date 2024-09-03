class Solution {
    public int getLucky(String sr, int k) {
        int sum = 0;
        
        // Convert each character to its position in the alphabet and sum the digits
        for (int i = 0; i < sr.length(); i++) {
            int c = sr.charAt(i) - 'a' + 1; // Position in the alphabet
            // Sum digits of the current number
            while (c > 0) {
                sum += c % 10;
                c /= 10;
            }
        }
        
        // Perform the transformation k-1 times
        return perform(sum, k - 1);
    }
    
    private int perform(int n, int k) {
        if (k == 0) return n;
        
        int sum = 0;
        // Sum the digits of the number
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        
        // Recur with the new sum and reduced k
        return perform(sum, k - 1);
    }
}
