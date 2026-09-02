class Solution {

    record State(int x, int y, int energy, int mask) {}

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        char[][] grid = new char[m][n];

        int sx = 0, sy = 0;
        int litterCount = 0;

        // Convert String[] -> char[][]
        for (int i = 0; i < m; i++) {
            grid[i] = classroom[i].toCharArray();

            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }

                if (grid[i][j] == 'L') {
                    litterCount++;
                }
            }
        }

        // Give every litter an ID
        int[][] litterId = new int[m][n];

        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        int id = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'L') {
                    litterId[i][j] = id++;
                }
            }
        }

        int fullMask = (1 << litterCount) - 1;

        /*
         * visited[x][y][energy][mask]
         */
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        Queue<State> queue = new LinkedList<>();

        queue.offer(new State(sx, sy, energy, 0));
        visited[sx][sy][energy][0] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int k = 0; k < size; k++) {

                State cur = queue.poll();

                int x = cur.x;
                int y = cur.y;
                int e = cur.energy;
                int mask = cur.mask;

                if (mask == fullMask) {
                    return moves;
                }

                for (int d = 0; d < 4; d++) {

                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= m ||
                        ny < 0 || ny >= n) {
                        continue;
                    }

                    if (grid[nx][ny] == 'X') {
                        continue;
                    }

                    if (e == 0) {
                        continue;
                    }

                    int newEnergy = e - 1;
                    int newMask = mask;

                    // Collect litter
                    if (grid[nx][ny] == 'L') {
                        int litter = litterId[nx][ny];
                        newMask |= (1 << litter);
                    }

                    // Recharge
                    if (grid[nx][ny] == 'R') {
                        newEnergy = energy;
                    }

                    if (!visited[nx][ny][newEnergy][newMask]) {

                        visited[nx][ny][newEnergy][newMask] = true;

                        queue.offer(
                            new State(nx, ny, newEnergy, newMask)
                        );
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}