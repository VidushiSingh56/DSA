// import java.util.Stack;

// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//         int mod = 1000000007;
//         int n = arr.length;
//         int[] pse = new int[n]; 
//         int[] nse = new int[n]; 
        
//         Stack<Pair<Integer, Integer>> st = new Stack<>();

        
//         for (int i = 0; i < n; i++) {
//             while (!st.isEmpty() && st.peek().getKey() >= arr[i]) {
//                 st.pop();
//             }
//             if (!st.isEmpty()) {
//                 pse[i] = st.peek().getValue();
//             } else {
//                 pse[i] = -1; 
//             }
//             st.push(new Pair<>(arr[i], i));
//         }
//         st.clear();
//         for (int i = n - 1; i >= 0; i--) {
//             while (!st.isEmpty() && st.peek().getKey() > arr[i]) {
//                 st.pop();
//             }
//             if (!st.isEmpty()) {
//                 nse[i] = st.peek().getValue();
//             } else {
//                 nse[i] = n; 
//             }
//             st.push(new Pair<>(arr[i], i));
//         }
        
//         long sum = 0;
//         for (int i = 0; i < n; i++) {
//             int leftRange = i - pse[i];   
//             int rightRange = nse[i] - i;  
            
//             long subarrayCount = (long) leftRange * rightRange;
//             sum = (sum + (subarrayCount * arr[i]) % mod) % mod;
//         }
        
//         return (int) sum;
//     }
// }


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




class Solution {
    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];
      
        Arrays.fill(left, -1);
        Arrays.fill(right, length);
      
        Deque<Integer> stack = new ArrayDeque<>();
      
        for (int i = 0; i < length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
      
        stack.clear();
      
        for (int i = length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
      
        int mod = (int) 1e9 + 7;
        long answer = 0;
      
        for (int i = 0; i < length; ++i) {
            answer += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
            answer %= mod;
        }
      
        return (int) answer;
    }
}