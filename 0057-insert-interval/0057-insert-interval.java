class Solution 
{
    public int[][] insert(int[][] intervals, int[] newInterval) 
    {
        int n = intervals.length;

        // int result[] = new int[n];

        List<int[]> list = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        int i = 0;
       while(i < n && intervals[i][1] < newInterval[0])
       {
            list.add(intervals[i]);
            i++;
       }


       while( i < n && intervals[i][0] <= end)
       {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
       }
        list.add( new int[] {start, end});
    

    while(i < n)
    {
        list.add(intervals[i]);
        i++;
    }

    return list.toArray(new int[list.size()][]);
    }
}