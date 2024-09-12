import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007; // Define the modulo value
        int n = arr.length;
        int[] pse = new int[n]; // Previous Smaller Element
        int[] nse = new int[n]; // Next Smaller Element
        
        Stack<Pair<Integer, Integer>> st = new Stack<>();

        // Calculate PSE (Previous Smaller Element)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek().getKey() >= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                pse[i] = st.peek().getValue();
            } else {
                pse[i] = -1; // No smaller element on the left
            }
            st.push(new Pair<>(arr[i], i));
        }
        
        // Clear the stack for reuse
        st.clear();
        
        // Calculate NSE (Next Smaller Element)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek().getKey() > arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                nse[i] = st.peek().getValue();
            } else {
                nse[i] = n; // No smaller element on the right
            }
            st.push(new Pair<>(arr[i], i));
        }
        
        // Calculate the sum of subarray minimums
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int leftRange = i - pse[i];   // Distance to the previous smaller element
            int rightRange = nse[i] - i;  // Distance to the next smaller element
            
            // Total subarray contribution of arr[i]
            long subarrayCount = (long) leftRange * rightRange;
            sum = (sum + (subarrayCount * arr[i]) % mod) % mod;
        }
        
        return (int) sum;
    }
}

// Helper class for Pair
class Pair<U, V> {
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getKey() {
        return first;
    }

    public V getValue() {
        return second;
    }
}
