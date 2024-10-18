// class Solution {
//     public boolean isBipartite(int[][] graph) 
//     {
//         int n = graph.length;
//         int color[] = new int[graph.length];
//         Arrays.fill(color, -1);
//         for(int i =0;i<n;i++)
//         {   
//             if(color[i] == -1)
//             {
//                 if(!isBi(graph, i, color))
//                 return false;
//             }
//         }
//         return true;
//     }
//     public boolean isBi(int graph[][], int node, int color[])
//     {
//         Queue<Integer> q = new LinkedList<>();
        
//         q.add(node);
//         color[node] = 0;
//         while(!q.isEmpty())
//         {
//             int nod = q.poll();
//             for(int it : graph[nod])
//             {
//                 if(color[it] == -1)
//                 {
//                     color[it] = color[nod] == 0 ? 1 : 0;
//                     q.add(it);
//                 }
//                 else if(color[it] == color[nod])
//                 return false;
//             }
//         }
//         return true;
//     }
// }


class Solution {
    public boolean isBipartite(int[][] graph) 
    {
        int n = graph.length;
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i =0;i<n;i++)
        {   
            if(color[i] == -1)
            {
                if(!isBi(graph, i,0, color))
                return false;
            }
        }
        return true;
    }
    public boolean isBi(int graph[][], int node,int col, int color[])
    {
        color[node] = col;
        for(int i : graph[node])
        {
            if(color[i] == -1)
            {
                if(! isBi(graph, i, col == 0 ? 1 : 0, color))
                return false;
            }
            else if(color[i] == col)
            return false;
        }
        return true;
    }
}