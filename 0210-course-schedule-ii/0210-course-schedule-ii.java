class Solution 
{
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
       List<List<Integer>> adjacencyList = new ArrayList<>();

       for(int i = 0;i<numCourses; i++)
       {
         adjacencyList.add(new ArrayList<>());
       }
        // 0 -> 1 2
        // 1 -> 3
        // 2 -
        // 3

       int indegree[] = new int[numCourses];

       for(int[] p : prerequisites)
       {
         int course = p[0];
         int prerequisite = p[1];

          adjacencyList.get(prerequisite).add(course);

          indegree[course]++;
       }

       Queue<Integer> q = new ArrayDeque<>();
       for(int i = 0; i<numCourses; i++)
       {
            if(indegree[i] == 0)
            {
                q.offer(i);
            }
       }

       int ans[] = new int[numCourses];
       int index = 0;
       while(!q.isEmpty())
       {
            int course = q.poll();
            ans[index] = course;
            index++;

            for(int children : adjacencyList.get(course))
            {
                indegree[children]--;

                if(indegree[children] == 0)
                {
                    q.offer(children);
                }
            }
       } 

        if(index != numCourses)
        {
            return new int[0];
        }

        return ans;
    }
}