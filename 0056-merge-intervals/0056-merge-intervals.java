class Solution {
    public int[][] merge(int[][] intervals) 
    {
        int n=intervals.length;
        List<List<Integer>> ans= new ArrayList<>();
       Arrays.sort(intervals, new Comparator<int[]>() {
          
            public int compare(int[] a, int[] b) {
                // Compare by the first column
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    // If the first column is the same, compare by the second column
                    return Integer.compare(a[1], b[1]);
                }
            }
        });
       
        int m=intervals[0][0];
        int p=intervals[0][1];
       for(int i=1;i<n;i++)
       {
         
        
          if(intervals[i][0]<=p)
          {
            if(intervals[i][1]>p)
            {
                p=intervals[i][1];
            }
            
          }
          else{
            List<Integer> sub = new ArrayList<>();
          
            sub.add(m);
            sub.add(p);
            ans.add(sub);
            m=intervals[i][0];
            p=intervals[i][1];
            
          }
           
       }
      List<Integer> sub = new ArrayList<>();
           
            sub.add(m);
            sub.add(p);
            ans.add(sub);
       
       int rows = ans.size(); 
       int cols = 2; 
       int[][] array2D = new int[rows][cols]; 
 
// Populate the 2D array 
       for (int i = 0; i < rows; i++) 
       { 
        List<Integer> innerList = ans.get(i); 
          for (int j = 0; j < cols; j++) 
          { 
           array2D[i][j] = innerList.get(j); 
          } 
        } 
        return array2D;


        
    }
}