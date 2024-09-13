class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        
        // Store to hold heights for each row-column combination
        int[][] store = new int[matrix.length][matrix[0].length];
        
        // Build the height histogram
        for (int i = 0; i < matrix[0].length; i++) {
            store[0][i] = matrix[0][i] - '0';  // Convert '1'/'0' chars to int
            
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[j][i] == '0') {
                    store[j][i] = 0;
                } else {
                    store[j][i] = store[j-1][i] + (matrix[j][i] - '0');
                }
            }
        }

        // Find the maximal rectangle for each row's histogram
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            int area = largestRectangleArea(store[i]);
            max = Math.max(max, area);
        }
        return max;
    }

    // Largest Rectangle in Histogram function
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nse[] = new int[n];
        int pse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        
        // Next smaller element (NSE) array
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        
        st.clear();
        int maxarea = 0;
        
        // Previous smaller element (PSE) array and calculating max area
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            int area = (nse[i] - pse[i] - 1) * heights[i];
            maxarea = Math.max(area, maxarea);
            st.push(i);
        }
        return maxarea;
    }
}
