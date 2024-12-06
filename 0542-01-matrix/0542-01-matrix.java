import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        
        // Directions for 4-neighborhood (up, right, down, left)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with all zero cells and mark non-zero cells as unprocessed
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    ans[i][j] = 0; // Distance to the nearest zero is 0
                } else {
                    ans[i][j] = -1; // Mark as unprocessed
                }
            }
        }

        // BFS from all zero cells
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            // Explore the 4-neighborhood
            for (int k = 0; k < 4; k++) {
                int xh = x + dx[k];
                int yh = y + dy[k];

                // Check bounds and if the cell is unprocessed
                if (xh >= 0 && xh < m && yh >= 0 && yh < n && ans[xh][yh] == -1) {
                    ans[xh][yh] = ans[x][y] + 1; // Update the distance
                    queue.offer(new int[]{xh, yh}); // Add to queue for further processing
                }
            }
        }

        return ans;
    }
}
