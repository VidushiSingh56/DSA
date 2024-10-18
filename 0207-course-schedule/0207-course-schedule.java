import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency list for graph representation
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int it[] : prerequisites)
        {
            adj.get(it[0]).add(it[1]);
        }
        List<Integer> topo = new ArrayList<>();
        Queue<Integer> st = new LinkedList<>();
        int indegree[] = new int[numCourses];
        for(int i = 0;i<numCourses;i++)
        {
            for(int it : adj.get(i))
            {
                indegree[it]++;
            }
        }
        for(int i =0;i<numCourses;i++)
        {
            if(indegree[i] == 0)
            st.add(i);
        }
        while(!st.isEmpty())
        {
            int node = st.poll();
            topo.add(node);
            for(int it : adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                st.add(it);
            }
        }
        if(topo.size() == numCourses)
        return true;

        return false;
    }
}
