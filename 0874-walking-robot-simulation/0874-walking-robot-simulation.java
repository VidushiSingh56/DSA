class Solution 
{
    public int robotSim(int[] commands, int[][] obstacles) 
    {
        Set<String> set = new HashSet<>();

        int dir[][] = {{0,1},  {1,0}, {0,-1}, {-1,0}};

        for(int i = 0; i<obstacles.length; i++)
        {
            set.add(obstacles[i][0] + "," + obstacles[i][1]);
        }

        int direction = 0;
        int x = 0, y=0;
        int max = 0;
        for(int i : commands)
        {
            if(i == -2)
            {
                direction = (direction + 3) % 4;
            }
            else if(i == -1)
            {
                direction = (direction + 1) % 4;
            }
            else
            {
                for(int a = 0; a < i; a++)
                {
                    int ax = x + dir[direction][0];
                    int ay = y + dir[direction][1];

                    if(set.contains(ax + "," + ay))
                    break;

                    x = ax;
                    y = ay;

                    max = Math.max(max, x*x+y*y);
                }
            }
        }
        System.out.println(x+""+y);
        return (max);
    }
}