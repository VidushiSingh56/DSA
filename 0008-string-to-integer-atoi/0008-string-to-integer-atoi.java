class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        String st = s.trim(); // Trim leading and trailing spaces
        int n = st.length();
        if (n == 0) {
            return 0;
        }

        int sign = 1;
        int index = 0;

        // Check for sign
        if (st.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (st.charAt(index) == '+') {
            index++;
        }

        // Initialize result and process digits
        int result = 0;
        while (index < n && Character.isDigit(st.charAt(index))) {
            int digit = st.charAt(index) - '0';
            
            // Check for overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
}
