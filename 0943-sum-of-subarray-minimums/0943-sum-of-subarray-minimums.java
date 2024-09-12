// import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;
        int[] pse = new int[n]; 
        int[] nse = new int[n]; 
        
        Stack<Integer> st = new Stack<>();

        
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                pse[i] = st.peek();
            } else {
                pse[i] = -1; 
            }
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i])
            {
                st.pop();
            }
            if (!st.isEmpty()) {
                nse[i] = st.peek();
            } else {
                nse[i] = n; 
            }
            st.push(i);
        }
        
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int leftRange = i - pse[i];   
            int rightRange = nse[i] - i;  
            
            long subarrayCount = (long) leftRange * rightRange;
            sum = (sum + (subarrayCount * arr[i]) % mod) % mod;
        }
        
        return (int) sum;
    }
}


// // class Pair<U, V> {
// //     public final U first;
// //     public final V second;

// //     public Pair(U first, V second) {
// //         this.first = first;
// //         this.second = second;
// //     }

// //     public U getKey() {
// //         return first;
// //     }

// //     public V getValue() {
// //         return second;
// //     }
// // }




