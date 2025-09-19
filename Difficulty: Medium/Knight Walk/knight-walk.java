class Triple {
    int x, y, steps;
    public Triple(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
    public int getx() { return x; }
    public int gety() { return y; }
    public int getsteps() { return steps; }
}

class Solution {
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        // Convert from 1-based chess coords (bottom-left origin) to 0-based array (top-left origin)
        int startX = N - KnightPos[0];  // flip row
        int startY = KnightPos[1] - 1;  // column stays same
        int targetX = N - TargetPos[0];
        int targetY = TargetPos[1] - 1;

        int[][] visited = new int[N][N];
        int dx[] = {-2,-1,1,2,2,1,-1,-2};
        int dy[] = {1,2,2,1,-1,-2,-2,-1};

        Queue<Triple> q = new LinkedList<>();
        q.offer(new Triple(startX, startY, 0));
        visited[startX][startY] = 1;

        while(!q.isEmpty()) {
            Triple t = q.poll();
            int x = t.getx();
            int y = t.gety();
            int steps = t.getsteps();

            // Target reached
            if(x == targetX && y == targetY) {
                return steps;
            }

            for(int i = 0; i < 8; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];

                if(xx >= 0 && xx < N && yy >= 0 && yy < N && visited[xx][yy] == 0) {
                    q.offer(new Triple(xx, yy, steps+1));
                    visited[xx][yy] = 1;
                }
            }
        }
        return -1;
    }
}
