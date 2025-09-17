import java.util.*;
class Solution 
{
    public int leastInterval(char[] tasks, int n) 
    {
        int freq[] = new int[26];
        for(char c:tasks)
        {
            freq[c-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<26;i++)
        {
            if(freq[i] > 0)
            pq.offer(freq[i]);
        }
        int times = 0;
        while(!pq.isEmpty())
        {
            int set = n+1;
            int taskcount = 0;
            List<Integer> store = new ArrayList<>();
            while(set > 0 && !pq.isEmpty())
            {
                int s = pq.poll();
                if(s > 1)
                {
                    store.add(s-1);
                }
                taskcount++;
                set--;
            }

            for(int i : store)
            {
                pq.offer(i);
            }

            times += pq.isEmpty() ? taskcount : n+1;
        }

        return times;

    }
}